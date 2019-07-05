package com.example.plannerr;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.plannerr.api.RetrofitClient;
import com.example.plannerr.models.ResponseObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText mEmail, mPassword;
    Button signIn;
    ProgressBar loginProgress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        Initialize view using their ids
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        signIn = findViewById(R.id.login);
        loginProgress = findViewById(R.id.loading);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
    }

    private void loginUser() {
        String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();

        //Validation for email
        if (email.isEmpty()){
            mEmail.setError("Email is required");
            mEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mEmail.setError("Incorrect Email");
            mEmail.requestFocus();
            return;
        }

        //Validation for Password
        if (password.isEmpty()){
            mPassword.setError("Password is required");
            mPassword.requestFocus();
            return;
        }

        loginProgress.setVisibility(View.VISIBLE);
        Call<ResponseObject> call = RetrofitClient.getInstance().getApi().login(email, password);
        call.enqueue(new Callback<ResponseObject>() {
            @Override
            public void onResponse(Call<ResponseObject> call, Response<ResponseObject> response) {

                if(response.code() == 200){
                    ResponseObject loginResponse = response.body();
                    String token = loginResponse.getData().getToken();
//                String loginMessage = response.body().getData().getUser().getName();
                    Toast.makeText(LoginActivity.this, token, Toast.LENGTH_LONG).show();
                    Intent dashboardIntent = new Intent(LoginActivity.this, Dashboard.class);
                    dashboardIntent.putExtra("token", token);
                    startActivity(dashboardIntent);
                    loginProgress.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onFailure(Call<ResponseObject> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                loginProgress.setVisibility(View.INVISIBLE);
            }
        });
    }
}
