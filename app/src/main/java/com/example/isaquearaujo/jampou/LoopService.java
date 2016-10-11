package com.example.isaquearaujo.jampou;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.Calendar;

/**
 * Created by isaque.araujo on 11/10/2016.
 */
public abstract class LoopService extends Service {
    private Handler handler;
    private AlarmManager alarmManager;
    public static final int INTERVAL = 5 * 1000;
    private boolean isFinish = false;

    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler();
        Loop();
    }
    private void Loop(){
        if(isFinish){
            stopSelf();
            return;
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Update();
                Loop();
            }
        }, 5 * 1000);
    }
    protected abstract void Update();

    protected void StopThis(){
        isFinish = true;
    }
}
