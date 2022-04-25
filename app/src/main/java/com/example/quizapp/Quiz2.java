package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Quiz2 extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb;
    Button next;
    String correctanswer="non";
    int scor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);


        rg=findViewById(R.id.rg2);
        rb=findViewById(R.id.rb2);
        rb=findViewById(R.id.rbb2);

        next=findViewById(R.id.next);
        Intent intent=getIntent();
        scor=intent.getIntExtra("score",0);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rg.getCheckedRadioButtonId()==-1){
                    return;
                }
                else{
                    rb=findViewById(rg.getCheckedRadioButtonId());
                    if(rb.getText().toString().equals(correctanswer)){
                        scor+=20;
                    }
                    Intent i=new Intent(Quiz2.this,Quiz3.class);
                    i.putExtra("score",scor);
                    startActivity(i);
                }
            }
        });
    }
}