package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Quiz4 extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb;
    Button next;
    String correctanswer="a droite";
    int scor2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4);

        rg=findViewById(R.id.rg4);
        rb=findViewById(R.id.rb4);
        rb=findViewById(R.id.rbb4);
        next=findViewById(R.id.next);
        Intent intent=getIntent();
        scor2=intent.getIntExtra("score",0);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rg.getCheckedRadioButtonId()==-1){
                    return;
                }
                else{
                    rb=findViewById(rg.getCheckedRadioButtonId());
                    if(rb.getText().toString().equals(correctanswer)){
                        scor2+=20;
                    }
                    Intent i=new Intent(Quiz4.this,Quiz5.class);
                    i.putExtra("score",scor2);
                    startActivity(i);
                }
            }
        });



    }
}