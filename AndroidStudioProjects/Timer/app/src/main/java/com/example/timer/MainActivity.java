package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int number = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(35000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                Log.d("LPG","OnTick : I am Hero");

            }

            @Override
            public void onFinish() {
                Log.d("LPG","Khatam hogya");
            }
        }.start();

        // Task Scheduler using handler and runnable
     //   final Handler handler = new Handler();
     //   Runnable run = new Runnable() {
     //       @Override
     //       public void run() {
     //           // code to Execute
     //           number++;
      //          Toast.makeText(MainActivity.this," This is toast "+ number,Toast.LENGTH_SHORT).show();
     //           handler.postDelayed(this,1000);
     //
       //     }
     //   };handler.post(run);
    }
}