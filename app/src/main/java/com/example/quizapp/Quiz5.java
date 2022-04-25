package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Quiz5 extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb;
    Button next;
    String correctanswer="non";
    int scor3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz5);

        rg=findViewById(R.id.rg5);
        rb=findViewById(R.id.rb5);
        rb=findViewById(R.id.rbb5);
        next=findViewById(R.id.next);
        Intent intent=getIntent();
        scor3=intent.getIntExtra("score",0);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rg.getCheckedRadioButtonId()==-1){
                    return;
                }
                else{
                    rb=findViewById(rg.getCheckedRadioButtonId());
                    if(rb.getText().toString().equals(correctanswer)){
                        scor3+=20;
                    }
                    Intent i=new Intent(Quiz5.this,Score.class);
                    i.putExtra("score",scor3);
                    startActivity(i);
                }
            }
        });
    }
}