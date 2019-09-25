package com.example.scorex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginAndSignup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);
    }

    public void loginFunc(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void signupFunc(View view){
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }
}
