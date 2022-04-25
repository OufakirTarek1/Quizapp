package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Quiz1 extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb;
    Button next;
    int score=0;
    String correctanswer="Le tramway circule";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);

        rg=findViewById(R.id.rg1);
        rb=findViewById(R.id.rb1);
        rb=findViewById(R.id.rbb1);
        next=findViewById(R.id.next);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rg.getCheckedRadioButtonId()==-1){
                    return;
                }
                else{
                    rb=findViewById(rg.getCheckedRadioButtonId());
                    if(rb.getText().toString().equals(correctanswer)){
                        score+=20;
                    }
                    Intent i=new Intent(Quiz1.this,Quiz2.class);
                    i.putExtra("score",score);
                    startActivity(i);
                }
            }
        });
    }

}