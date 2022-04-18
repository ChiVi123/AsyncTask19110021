package com.android.s19110021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtStateTask;
    private Button btnStart;
    private ProgressBar progressBar;
    private AsyncTask asyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initActivity();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtStateTask.setText("Working...");
                run();
            }
        });
    }

    private void initActivity() {
        txtStateTask = findViewById(R.id.state_task);
        btnStart = findViewById(R.id.btn_start);
        progressBar = findViewById(R.id.progress_horizontal);
    }

    private void run() {
        progressBar.setMax(100);

        CountDownTimer countDownTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long l) {
                int current = progressBar.getProgress();
                if(current >= progressBar.getMax()) {
                    current = 0;
                }
                progressBar.setProgress(current + 10);
                return;
            }

            @Override
            public void onFinish() {
                txtStateTask.setText("done.");
            }
        };
        countDownTimer.start();
    }
}