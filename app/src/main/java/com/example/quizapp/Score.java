package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Score extends AppCompatActivity {
    TextView score;
    com.github.lzyzsd.circleprogress.DonutProgress progress;
    Button logout;
    Button tryagain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        logout=findViewById(R.id.logout);
        tryagain=findViewById(R.id.tryagain);
        progress=findViewById(R.id.progress);
        Intent intent=getIntent();
        int scor3=intent.getIntExtra("score",0);

        progress.setDonut_progress(String.valueOf(scor3));



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Score.this,MainActivity.class);
                startActivity(intent);
            }

        });
        tryagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Score.this,Quiz1.class);
                startActivity(intent);
            }

        });
    }
}