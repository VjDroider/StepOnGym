package com.stepon.gymapp;


import com.stepon.gymapp.model.login.ModelLogin;
import com.stepon.gymapp.model.ModelRegister;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {


    @FormUrlEncoded
    @POST("api_file/gym_login.php")
    Call<ModelLogin> createLogin(

            @Field("email") String email,
            @Field("password") String password

    );

    @FormUrlEncoded
    @POST("api_file/gym_register.php")
    Call<ModelRegister> userRegister(

            @Field("mobile") String phone,
            @Field("email") String email,
            @Field("password") String password

    );





}
