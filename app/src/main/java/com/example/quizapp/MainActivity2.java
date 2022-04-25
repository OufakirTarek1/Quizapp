package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {

    EditText email,password,comfirmpassword;
    Button register;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        auth=FirebaseAuth.getInstance();
        email=findViewById(R.id.Email);
        password=findViewById(R.id.Password);
        comfirmpassword=findViewById(R.id.Password1);
        register=findViewById(R.id.buttonLogin);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity2.this,"plese provide email",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(MainActivity2.this,"plese provide password",Toast.LENGTH_LONG).show();
                    return;

                }
                if(!password.getText().toString().equals((comfirmpassword.getText().toString()))){
                    Toast.makeText(MainActivity2.this,"password is not the same",Toast.LENGTH_LONG).show();
                    return;

                }
               auth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(MainActivity2.this, new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Intent i = new Intent(MainActivity2.this, MainActivity.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(MainActivity2.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                    }

                   }
               });
            }
        });
    }
}