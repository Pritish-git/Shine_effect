package com.technical.myapplication;


import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {

    private ImageView Img, Shine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Img = findViewById(R.id.img);
        Shine = findViewById(R.id.shine);

        //Start the animations preoidically by calling 'shineStart' method with ScheduledExecutorService
        ScheduledExecutorService executorService =
                Executors.newSingleThreadScheduledExecutor();

        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        shineStart();
                    }
                });
            }
        }, 3,3, TimeUnit.SECONDS);


        


    }

    private void shineStart() {

        Animation animation = new TranslateAnimation(
                0,Img.getWidth()+Shine.getWidth(),0,0);
        animation.setDuration(550);
        animation.setFillAfter(false);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        Shine.startAnimation(animation);
    }

}