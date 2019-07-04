package com.example.plannerr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button to_signup;
    TextView to_sign_in;
    private int buttonState = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        to_signup = findViewById(R.id.signup_btn);
        to_sign_in = findViewById(R.id.sign_in_text);

        to_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(buttonState % 2 == 0){
//                    to_signup.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//                }
//                else{
//                    to_signup.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//                }
//                buttonState++;
                Intent toSignup = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(toSignup);
            }

        });

        to_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toSignin = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(toSignin);
            }
        });
    }
}
