package de.eliah.presenter;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MessageSender extends AsyncTask<String, Void, Void> {

    Socket s;
    DataOutputStream dos;
    PrintWriter pw;

    @Override
    protected Void doInBackground(String... strings) {

        try {
            s = new Socket(MainActivity.ipAddr, 5005);
            pw = new PrintWriter(s.getOutputStream());
            pw.write(strings[0]);
            pw.flush();
            pw.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
