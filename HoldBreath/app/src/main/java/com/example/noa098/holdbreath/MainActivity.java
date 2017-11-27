package com.example.noa098.holdbreath;

import android.app.Activity;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textHold;
    private TextView textRest;
    private Button start;
    private Handler handler = new Handler();
    private Handler handler2 = new Handler();
    private  Handler handler3 = new Handler();
    int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textHold = (TextView)findViewById(R.id.textHold);
        textRest= (TextView)findViewById(R.id.textRest);
        start = (Button)findViewById(R.id.startBN);
        start.setOnClickListener(MainActivity.this);




    }

    public void onClick(View v){
        new Thread(new Runnable() {
            public void run() {
                new CountDownTimer(10000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        textHold.setText("憋氣時間 " + millisUntilFinished / 1000);
                    }

                    public void onFinish() {

                        textHold.setText("take a rest");

                    }

                }.start();//我要做的事
                Looper.prepare();
                new Handler().post(new Runnable(){

                    @Override
                    public void run() {
                        new CountDownTimer(10000, 1000) {

                            public void onTick(long millisUntilFinished) {
                                textRest.setText("憋氣時間 " + millisUntilFinished / 1000);
                            }

                            public void onFinish() {
                                // textHold.setText("Take a rest");
                                textRest.setText("憋氣");

                            }
                        }.start();//第二件事
                    }
                });
                new Handler().post(new Runnable(){

                    @Override
                    public void run() {
                        new CountDownTimer(10000, 1000) {

                            public void onTick(long millisUntilFinished) {
                                textHold.setText("憋氣時間 " + millisUntilFinished / 1000);
                            }

                            public void onFinish() {

                                textHold.setText("take a rest");


                            }

                        }.start();//第三件事
                        Looper.myLooper().quit();
                    }
                });

                Looper.loop();

                new CountDownTimer(5000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        textRest.setText("憋氣時間 " + millisUntilFinished / 1000);
                    }

                    public void onFinish() {

                        textRest.setText("憋氣2");
                    }
                }.start();

            }
        }).start();
       /* new CountDownTimer(120000, 1000) {

            public void onTick(long millisUntilFinished) {
                textHold.setText("憋氣時間 " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                textRest.setText("done!");
            }
        }.start();*/
    }
    private  Runnable runnable = new Runnable() {
        @Override
        public void run() {
            new CountDownTimer(10000, 1000) {

                public void onTick(long millisUntilFinished) {
                    textHold.setText("憋氣時間 " + millisUntilFinished / 1000);
                }

                public void onFinish() {

                    textHold.setText("take a rest");
                    handler2.post(runnable2);

                   // String s = String.valueOf(i);
                  /*  textHold.setText("done!");*/


                }

            }.start();
           /* if(i==2) {
                new CountDownTimer(10000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        textHold.setText("憋氣時間 " + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        textHold.setText("Take a rest");
                        handler3.post(runnable3);
                    }
                }.start();
            }else {
                textHold.setText("i!=2");
            }*/
        }


    };
   private  Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            new CountDownTimer(10000, 1000) {

                public void onTick(long millisUntilFinished) {
                    textRest.setText("憋氣時間 " + millisUntilFinished / 1000);
                }

                public void onFinish() {
                   // textHold.setText("Take a rest");
                    textRest.setText("憋氣");

                }
            }.start();
        }
    };
   private Runnable runnable3 = new Runnable() {
       @Override
       public void run() {
           new CountDownTimer(5000, 1000) {

               public void onTick(long millisUntilFinished) {
                   textRest.setText("憋氣時間 " + millisUntilFinished / 1000);
               }

               public void onFinish() {
                  // textHold.setText("Take a rest");
                   textRest.setText("憋氣2");
               }
           }.start();
       }
   };

}


