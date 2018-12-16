package com.example.thread;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {

    private int value = 0;
    private boolean running = false;

    TextView textView01;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn=(Button)findViewById(R.id.view1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        textView01 = (TextView) findViewById(R.id.textView01);

        Button showBtn = (Button) findViewById(R.id.showBtn);
        showBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView01.setText("값 : " + value);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        running = true;
        Thread thread1 = new BackgroundThread();
        thread1.start();
    }


    protected void onPause() {
        super.onPause();

        running = false;
        value = 0;
    }


    class BackgroundThread extends Thread {
        public void run() {
            while(running) {
                try {

                    Thread.sleep(1000);
                    value++;

                } catch(InterruptedException ex) {
                    Log.e("SampleJavaThread", "Exception in thread.", ex);
                }
            }
        }
    }

}
