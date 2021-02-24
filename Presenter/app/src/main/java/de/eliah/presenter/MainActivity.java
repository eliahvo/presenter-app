package de.eliah.presenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Intent intentVolumeListener = null;
    public static String ipAddr = "";
    EditText textIP;
    Button btnOk;
    TextView textStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textIP = findViewById(R.id.textIpAddr);
        btnOk = findViewById(R.id.btnOk);
        textStatus = findViewById(R.id.textStatus);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ipAddr = textIP.getText().toString();
                textStatus.setText("Setted Text: " + ipAddr);

                intentVolumeListener = new Intent(MainActivity.this, VolumeListenerService.class);
                startService(intentVolumeListener);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(intentVolumeListener);
    }
}


