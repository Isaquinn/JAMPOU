package com.example.isaquearaujo.jampou;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by isaque.araujo on 11/10/2016.
 */
public class ServiceClass extends LoopService{
    private Handler handler;
    public static final String PREFS_NAME = "jampou";
    private SharedPreferences settings;

    private int qtcomida, qtagua;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        settings = getSharedPreferences(PREFS_NAME, 0);
    }

    @Override
    protected void Update() {
        qtagua = settings.getInt("agua", 100);
        qtcomida = settings.getInt("comida", 100);

        if(qtcomida <= 0 && qtagua <= 0)
            return;

        qtagua -= 10;
        qtcomida -= 10;

        if(qtagua < 0)
            qtagua = 0;
        if(qtcomida < 0)
            qtcomida = 0;

        Toast.makeText(this, "AGUA: " + qtagua + ", COMIDA: " + qtcomida, Toast.LENGTH_SHORT).show();

        if(qtagua == 10 || qtcomida == 10){
            NotificationCompat.Builder body = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("To morreno")
                    .setContentText("Mim da " + (qtagua == 10 ? "agua" : "comida"));
            int mNotificationId = 001;
            NotificationManager mNotifyMgr =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            mNotifyMgr.notify(mNotificationId, body.build());
        }

        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("agua", qtagua);
        editor.putInt("comida", qtcomida);

        editor.commit();

//        if(qtagua <= 0|| qtcomida <= 0)
//            StopThis();
    }
}
