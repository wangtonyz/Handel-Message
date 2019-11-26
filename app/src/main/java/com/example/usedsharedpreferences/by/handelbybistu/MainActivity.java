package com.example.usedsharedpreferences.by.handelbybistu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String TAG="ErJike-Handler";
    public static final int THREAD1 = 1;
    public static final int THREAD2 = 2;
    public static final int THREAD3 = 3;
    private ProgressBar progressBar;
    private Handler handler = new Handler() {

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case THREAD1:

                    int midint=progressBar.getProgress();
                    Log.i(TAG, "handleMessage:(midint) "+midint);
                    if(midint<=90)
                        progressBar.setProgress(midint+10);
                    else
                        progressBar.setProgress(100);


                    break;
                case THREAD2:
                    int midint2=progressBar.getProgress();
                    Log.i(TAG, "handleMessage:(midint) "+midint2);
                    if(midint2<=80)
                        progressBar.setProgress(midint2+20);
                    else
                        progressBar.setProgress(100);

                    break;
                case THREAD3:
                    int midint3=progressBar.getProgress();
                    Log.i(TAG, "handleMessage:(midint) "+midint3);
                    if(midint3>=10)
                        progressBar.setProgress(midint3-10);
                    else
                        progressBar.setProgress(0);

                    break;
                default:
                    Log.i(TAG, "handleMessage: case错误");
            }

        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View.OnClickListener normelListener= new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.run_thread1:
                        new Thread(new Runnable(){
                            @Override
                            public void run(){
                                Message message=new Message();
                                message.what=THREAD1;
                                handler.sendMessage(message);
                            }

                        }).start();
                        break;
                    case R.id.run_thread2:
                        new Thread(new Runnable(){
                            @Override
                            public void run(){
                                Message message=new Message();
                                message.what=THREAD2;
                                handler.sendMessage(message);
                            }

                        }).start();
                        break;
                    case R.id.run_thread3:
                        new Thread(new Runnable(){
                            @Override
                            public void run(){
                                Message message=new Message();
                                message.what=THREAD3;
                                handler.sendMessage(message);
                            }

                        }).start();
                        break;
                    default:

                }
            }
        };
        Button buttonThread1 = (Button) findViewById(R.id.run_thread1);
        buttonThread1.setOnClickListener(normelListener);
        Button buttonThread2 = (Button) findViewById(R.id.run_thread2);
        buttonThread2.setOnClickListener(normelListener);
        Button buttonThread3 = (Button) findViewById(R.id.run_thread3);
        buttonThread3.setOnClickListener(normelListener);
        progressBar=(ProgressBar)findViewById(R.id.progress_bar_h);

    }
}
