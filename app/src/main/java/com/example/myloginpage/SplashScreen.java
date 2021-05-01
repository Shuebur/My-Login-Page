package com.example.myloginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {
    private ProgressBar progressBar;
    private int Progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_splash_screen);
        progressBar=findViewById(R.id.Pro);
        Thread thread= new Thread(new  Runnable() {
            @Override
            public void run() {
                dowork();
                start();
            }
        });
        thread.start();
    }
    public void dowork(){
        for(Progress=20;Progress<=100;Progress=Progress+20){


            try {
                Thread.sleep(1000);
                progressBar.setProgress(Progress);
            }
            catch (InterruptedException e){

                e.printStackTrace();}}}

    public void start(){

        Intent intent=new Intent(SplashScreen.this,MainActivity.class);
        startActivity(intent);
        finish();




    }

}

