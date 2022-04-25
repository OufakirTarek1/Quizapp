package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Quiz3 extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb;
    Button next;
    String correctanswer="non";
    int scor1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);

        rg=findViewById(R.id.rg3);
        rb=findViewById(R.id.rb3);
        rb=findViewById(R.id.rbb3);
        next=findViewById(R.id.next);
        Intent intent=getIntent();
        scor1=intent.getIntExtra("score",0);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rg.getCheckedRadioButtonId()==-1){
                    return;
                }
                else{
                    rb=findViewById(rg.getCheckedRadioButtonId());
                    if(rb.getText().toString().equals(correctanswer)){
                        scor1+=20;
                    }
                    Intent i=new Intent(Quiz3.this,Quiz4.class);
                    i.putExtra("score",scor1);
                    startActivity(i);
                }
            }
        });
    }
}