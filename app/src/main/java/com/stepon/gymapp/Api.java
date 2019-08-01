package com.stepon.gymapp;


import com.stepon.gymapp.model.ModelCategory;
import com.stepon.gymapp.model.ModelWeek;
import com.stepon.gymapp.model.login.ModelDetail;
import com.stepon.gymapp.model.login.ModelLogin;
import com.stepon.gymapp.model.ModelRegister;

import java.util.List;

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
    @POST("api_file/gym_category.php")
    Call<List<ModelCategory>> getCategory();

    @POST("api_file/gym_week.php")
    Call<List<ModelWeek>> getWeek();

    @FormUrlEncoded
    @POST("api_file/gym_detail.php")
    Call<List<ModelDetail>> getDetail(
            @Field("week_id") String week_id
    );




}
