package de.eliah.presenter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class VolumeListenerService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();

        ToneGenerator beep = new ToneGenerator(AudioManager.STREAM_MUSIC, 0);
        beep.startTone(ToneGenerator.TONE_CDMA_DIAL_TONE_LITE); //start silent sound

        final AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        final int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,maxVolume/2, AudioManager.FLAG_SHOW_UI);

        final BroadcastReceiver vReceiver = new BroadcastReceiver() {

            boolean checked = false; //variable to bypass second run through onReceive()

            @Override
            public void onReceive(Context context, Intent intent) {
                //Log.i("**LOG**: ", intent.getAction());

                if(intent.getAction() == "android.media.VOLUME_CHANGED_ACTION"){
                    if(!checked){
                        checked = true;
                    }else{
                        checked = false;
                        return;
                    }

                    int newVolume = (Integer)intent.getExtras().get("android.media.EXTRA_VOLUME_STREAM_VALUE");

                    if(newVolume > (maxVolume / 2)){
                        Log.i("Volume: ", "volume up / " + newVolume + " / ");
                        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,maxVolume/2, AudioManager.FLAG_SHOW_UI);


                        //send command 'forwards'
                        MessageSender msg = new MessageSender();
                        msg.execute("forward");
                    }else if(newVolume < (maxVolume / 2)){
                        Log.i("Volume: ", "volume down / " + newVolume);
                        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,maxVolume/2, AudioManager.FLAG_SHOW_UI);

                        //send command 'backwards'
                        MessageSender msg = new MessageSender();
                        msg.execute("backward");
                    }else{
                        Log.e("Volume: ", "volume changed but nothing happened! / " + newVolume);
                    }
                }
            }
        };

        //create IntentFilter and register the BroadcastReceiver with the filter as argument
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        registerReceiver(vReceiver, intentFilter);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
