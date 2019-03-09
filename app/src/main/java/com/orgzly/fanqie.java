package com.orgzly;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class fanqie extends AppCompatActivity {

    private int minute = 25;//这是分钟
    private int second = 0;//这是分钟后面的秒数。
    private TextView timeView;
    private Timer timer;
    private TimerTask timerTask;
    private int flg=1;
    //这是接收回来处理的消息
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (minute == 0) {
                if (second == 0) {
                    timeView.setText("时间到 !");
                    if (timer != null) {
                        timer.cancel();
                        timer = null;
                    }
                    if (timerTask != null) {
                        timerTask = null;
                    }
                } else {
                    second--;
                    if (second >= 10) {
                        timeView.setText("0" + minute + ":" + second);
                    } else {
                        timeView.setText("0" + minute + ":0" + second);
                    }
                }
            } else {
                if (second == 0) {
                    second = 59;
                    minute--;
                    if (minute >= 10) {
                        timeView.setText(minute + ":" + second);
                    } else {
                        timeView.setText("0" + minute + ":" + second);
                    }
                } else {
                    second--;
                    if (second >= 10) {
                        if (minute >= 10) {
                            timeView.setText(minute + ":" + second);
                        } else {
                            timeView.setText("0" + minute + ":" + second);
                        }
                    } else {
                        if (minute >= 10) {
                            timeView.setText(minute + ":0" + second);
                        } else {
                            timeView.setText("0" + minute + ":0" + second);
                        }
                    }
                }
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fanqie);

    }

    public void onDestroy(View view) {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        if (timerTask != null) {
            timerTask = null;
        }
        minute = -1;
        second = -1;
        super.onDestroy();
    }



    //@Override
    public void start(View view) {
      // super.onStart();
        timeView = (TextView) findViewById(R.id.textView3);

        timeView.setText(minute + ":" + second);

        timerTask = new TimerTask() {

            @Override
            public void run() {
                Message msg = new Message();
                msg.what = 0;
                handler.sendMessage(msg);
            }
        };

        timer = new Timer();
        timer.schedule(timerTask, 0, 1000);
    }

    public void stop(View view) {
        super.onStop();
        /*
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        if (timerTask != null) {
            timerTask = null;
        }
        */
        minute = 25;
        second = 00;
        timeView = (TextView) findViewById(R.id.textView3);

        timeView.setText(minute + ":" + second);
    }

    //public void Resume(View view) {
    //    super.onResume();
    //}

    //@Override
    //protected void onRestart() {
   //     super.onRestart();
    //}

    public void onPause(View view) {
        flg =flg * -1;
        if(flg==-1)
            super.onPause();
        else
            super.onResume();
    }
    public void putong(View view) {
        EditText h = (EditText) findViewById(R.id.editText5);
        EditText m = (EditText) findViewById(R.id.editText6);
        EditText s = (EditText) findViewById(R.id.editText4);
        String hour = h.getText().toString();
        String min = m.getText().toString();
        String sec = s.getText().toString();

        minute=Integer.valueOf(hour).intValue() * 60 + Integer.valueOf(min).intValue();
        second=Integer.valueOf(sec).intValue();

        if(minute == 0 && second == 0 )
            minute=25;
        //start(view);

    }
}
