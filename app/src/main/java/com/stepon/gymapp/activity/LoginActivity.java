package com.stepon.gymapp.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



import com.stepon.gymapp.R;
import com.stepon.gymapp.RetrofitClient;
import com.stepon.gymapp.model.login.ModelLogin;
import com.stepon.gymapp.storage.SharedPrefManager;
import com.stepon.gymapp.utils.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private SharedPrefManager tSharedPrefManager;
    private Context tContext;
    EditText etemail, etpass;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tContext = LoginActivity.this;
        tSharedPrefManager = new SharedPrefManager(tContext);

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


                ModelLogin tModel = response.body();
                Toast.makeText(getApplicationContext(), tModel.getMessage(), Toast.LENGTH_LONG).show();

                String strId = tModel.getUser().getId();
                String strName = tModel.getUser().getName();
                String strMobile = tModel.getUser().getMobile();
                String strEmail = tModel.getUser().getEmail();
                String strDob = tModel.getUser().getUserDob();
                String strAddress = tModel.getUser().getAddress();
                String strDoj = tModel.getUser().getCreatedAt();
                tSharedPrefManager.setUserData(strId, strName, strMobile, strEmail, strDob, strDoj);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finishAffinity();
                finish();



            }

            @Override
            public void onFailure(Call<ModelLogin> call, Throwable t) {

                Log.d(Constant.TAG, "Login Failed : "+t);
            }
        });

    }


    public void onclick(View view) {

        switch (view.getId()) {
            case R.id.btn_log:
                userLogin();

                break;
        }
    }
}