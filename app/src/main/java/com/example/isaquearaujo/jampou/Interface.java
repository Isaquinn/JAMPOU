package com.example.isaquearaujo.jampou;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Interface extends AppCompatActivity implements View.OnClickListener{
    private ImageView pou, agua, comida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);
        pou = (ImageView)findViewById(R.id.pou);
        agua = (ImageView)findViewById(R.id.agua);
        comida = (ImageView)findViewById(R.id.comida);
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.pou)
        {

        }
        if(v.getId() == R.id.agua)
        {

        }
        if(v.getId() == R.id.comida)
        {

        }
    }
}
