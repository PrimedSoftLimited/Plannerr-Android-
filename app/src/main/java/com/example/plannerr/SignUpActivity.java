package com.example.plannerr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.plannerr.api.RetrofitClient;
import com.example.plannerr.models.ResponseObject;
import com.google.firebase.auth.FirebaseAuth;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    private EditText username, email, phoneNo, password, cnfPassword;
    Button toConfirm;
    ProgressBar mProgressbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

//        Initialize views using id's
        username = findViewById(R.id.input_username);
        email = findViewById(R.id.input_email);
        phoneNo = findViewById(R.id.input_phone);
        password = findViewById(R.id.input_password);
        cnfPassword = findViewById(R.id.input_cnfpassword);
        toConfirm = findViewById(R.id.create_acct);
        mProgressbar = findViewById(R.id.signup_progressbar);
        mAuth = FirebaseAuth.getInstance();

//        Handles the onClick to signup
        toConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userSignUp();
            }
        });
    }

    private void userSignUp() {
        String mUsername = username.getText().toString().trim();
        String mEmail = email.getText().toString().trim();
        String mPhone = phoneNo.getText().toString().trim();
        String mPassword = password.getText().toString().trim();
        String mCnfPassword = cnfPassword.getText().toString().trim();
//        String mCategory = categorySpinner.getItemAtPosition(getComponentName())

        //Validations for username fields required
        if (mUsername.isEmpty()){
            username.setError("Username is required");
            username.requestFocus();
            return;
        }

        //Validation for email
        if (mEmail.isEmpty()){
            email.setError("Email is required");
            email.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(mEmail).matches()){
            email.setError("Incorrect Email");
            email.requestFocus();
            return;
        }

        //Validation for phone number
        if (mPhone.isEmpty()){
            phoneNo.setError("Phone number is required");
            phoneNo.requestFocus();
            return;
        }
        if (mPhone.length()<11 || mPhone.length()>11){
            phoneNo.setError("Enter a correct phone number");
            phoneNo.requestFocus();
            return;
        }

        //Validation for Password
        if (mPassword.isEmpty()){
            password.setError("Password is required");
            password.requestFocus();
            return;
        }

//        Validation for confirm Password
        if (mCnfPassword.isEmpty()){
            cnfPassword.setError("Password is required");
            cnfPassword.requestFocus();
            return;
        }
        if (!mCnfPassword.equals(mCnfPassword)){
            cnfPassword.setError("Password does not match");
            cnfPassword.requestFocus();
            return;
        }

        mProgressbar.setVisibility(View.VISIBLE);
//        Retrofit call
        Call<ResponseObject> call = RetrofitClient.getInstance().getApi().register(mUsername, mEmail, mPhone, mPassword, mCnfPassword);
        call.enqueue(new Callback<ResponseObject>() {
            @Override
            public void onResponse(Call<ResponseObject> call, Response<ResponseObject> response) {

                ResponseObject signupObject = response.body();
                if (response.code() == 201){
                    Toast.makeText(SignUpActivity.this, response.message(), Toast.LENGTH_LONG).show();
                    Intent loginIntent = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(loginIntent);
                    mProgressbar.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void onFailure(Call<ResponseObject> call, Throwable t) {
                Toast.makeText(SignUpActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                mProgressbar.setVisibility(View.INVISIBLE);
            }
        });
    }
}
