package com.asper.karwaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();
        handler.postDelayed(r,3000);

        getSupportActionBar().hide();

    }
    Runnable r = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(MainActivity.this,Nav_activity.class);
            startActivity(intent);
            finish();
        }
    };
}