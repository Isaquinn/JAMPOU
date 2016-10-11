package com.example.isaquearaujo.jampou;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class Interface extends AppCompatActivity implements View.OnClickListener{
    private ImageView pou, agua, comida;
    private int qtcomida, qtagua;
    private SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);
        pou = (ImageView)findViewById(R.id.pou);
        agua = (ImageView)findViewById(R.id.agua);
        comida = (ImageView)findViewById(R.id.comida);

        Intent intent = new Intent(this, ServiceClass.class);
        PendingIntent pintent = PendingIntent.getService(this, 0, intent, 0);
        AlarmManager alarm = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarm.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pintent);

        settings = getSharedPreferences(ServiceClass.PREFS_NAME, 0);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.pou)
        {

        }
        if(v.getId() == R.id.agua)
        {
            AddAgua(10);
        }
        if(v.getId() == R.id.comida)
        {
            AddComida(10);
        }
    }

    private void AddComida(int add){
        qtcomida = settings.getInt("comida", 100);
        qtcomida += add;
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("comida", qtcomida);
        editor.commit();
    }

    private void AddAgua(int add){
        qtcomida = settings.getInt("agua", 100);
        qtcomida += add;
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("agua", qtcomida);
        editor.commit();
    }
}
