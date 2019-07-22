package com.stepon.gymapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



import com.stepon.gymapp.R;
import com.stepon.gymapp.RetrofitClient;
import com.stepon.gymapp.model.ModelLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    EditText etemail, etpass;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        etemail = findViewById(R.id.et_email_log);
        etpass = findViewById(R.id.et_pass_pass);
        btn = findViewById(R.id.btn_log);


    }


    private void userLogin() {

        String email = etemail.getText().toString().trim();
        String password = etpass.getText().toString().trim();


        if (email.isEmpty()) {
            etemail.setError("Email is required");
            etemail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etemail.setError("Enter a valid email");
            etemail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            etpass.setError("Password required");
            etpass.requestFocus();
            return;
        }

        if (password.length() < 6) {
            etpass.setError("Password should be 6 character long");
            etpass.requestFocus();
            return;

        }


        Call<ModelLogin> call = RetrofitClient
                .getInstance()
                .getApi()
                .createLogin(email, password);


        call.enqueue(new Callback<ModelLogin>() {
            @Override
            public void onResponse(Call<ModelLogin> call, Response<ModelLogin> response) {


                ModelLogin ml = response.body();
                Toast.makeText(getApplicationContext(), ml.getMessage(), Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<ModelLogin> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Failed Check Network Connectivity", Toast.LENGTH_LONG).show();
            }
        });


    }


    public void onclick(View view) {

        switch (view.getId()) {
            case R.id.btn_log:
                userLogin();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}