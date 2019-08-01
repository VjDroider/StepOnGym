package com.stepon.gymapp.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



import com.stepon.gymapp.R;
import com.stepon.gymapp.RetrofitClient;
import com.stepon.gymapp.model.login.ModelLogin;
import com.stepon.gymapp.storage.SharedPrefManager;
import com.stepon.gymapp.utils.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private SharedPrefManager tSharedPrefManager;
    private Context tContext;
    @BindView(R.id.etEmailLogin)
    protected EditText etEmailLogin;
    @BindView(R.id.etPassLogin)
    protected EditText etPassLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        tContext = LoginActivity.this;
        tSharedPrefManager = new SharedPrefManager(tContext);




    }


    private void userLogin() {

        String email = etEmailLogin.getText().toString().trim();
        String password = etPassLogin.getText().toString().trim();


        if (email.isEmpty()) {
            etEmailLogin.setError("Email is required");
            etEmailLogin.requestFocus();
        }
       else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmailLogin.setError("Enter a valid email");
            etEmailLogin.requestFocus();
        }

       else if (password.isEmpty()) {
            etPassLogin.setError("Password required");
            etPassLogin.requestFocus();
        }

        else if (password.length() < 6) {
            etPassLogin.setError("Password should be 6 character long");
            etPassLogin.requestFocus();

        }else{
            callApiLogin(email, password);
        }



    }

    private void callApiLogin(String strEmail,  String strPassword){
        Call<ModelLogin> call = RetrofitClient
                .getInstance()
                .getApi()
                .createLogin(strEmail, strPassword);


        call.enqueue(new Callback<ModelLogin>() {
            @Override
            public void onResponse(Call<ModelLogin> call, Response<ModelLogin> response) {


                ModelLogin tModel = response.body();
                if (!tModel.getError()) {
                    Toast.makeText(getApplicationContext(), tModel.getMessage(), Toast.LENGTH_LONG).show();
                    String strId = tModel.getUser().getId();
                    String strName = tModel.getUser().getName();
                    String strMobile = tModel.getUser().getMobile();
                    String strEmail = tModel.getUser().getEmail();
                    String strDob = tModel.getUser().getUserDob();
                    String strAddress = tModel.getUser().getAddress();
                    String strDoj = tModel.getUser().getCreatedAt();
                    tSharedPrefManager.setUserData(strId, strName, strMobile, strEmail, strDob, strDoj);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finishAffinity();
                    finish();
                }
                else  {
                    Toast.makeText(getApplicationContext(), tModel.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ModelLogin> call, Throwable t) {

                Log.d(Constant.TAG, "Login Failed : "+t);
            }
        });

    }

@OnClick(R.id.btnLogin)
    public void btn_logClicked(View view){
    userLogin();
}
@OnClick(R.id.tvSignUp)
    public void tvSignUpClicked(View view){
    startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
}

}