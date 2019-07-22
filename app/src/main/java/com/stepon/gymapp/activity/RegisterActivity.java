package com.stepon.gymapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.stepon.gymapp.R;
import com.stepon.gymapp.RetrofitClient;
import com.stepon.gymapp.model.ModelRegister;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterActivity extends AppCompatActivity {

    EditText etmobile, etemail, etpass;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        etmobile = findViewById(R.id.et_mobile);
        etemail = findViewById(R.id.et_email);
        etpass = findViewById(R.id.et_pass);
        btn = findViewById(R.id.btn_reg);
        //  tv = findViewById(tv_log_signup);

    }




    private void userSignUp() {
        String mobile = etmobile.getText().toString().trim();
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


        Call<ModelRegister> call = RetrofitClient
                .getInstance()
                .getApi()
                .userRegister(mobile, email, password);

        //   jaihanuman

        call.enqueue(new Callback<ModelRegister>() {
            @Override
            public void onResponse(Call<ModelRegister> call, Response<ModelRegister> response) {

                ModelRegister m = response.body();

                Toast.makeText(getApplicationContext(), "Sucess", Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<ModelRegister> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_LONG).show();

            }
        });


    }


    public void onclick(View view) {


        switch (view.getId()) {
            case R.id.btn_reg:
                userSignUp();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
