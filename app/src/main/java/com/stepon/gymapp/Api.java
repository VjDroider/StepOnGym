package com.stepon.gymapp;


import com.stepon.gymapp.model.ModelCategory;
import com.stepon.gymapp.model.ModelDayWork;
import com.stepon.gymapp.model.ModelDiet;
import com.stepon.gymapp.model.ModelWeek;
import com.stepon.gymapp.model.login.ModelDetail;
import com.stepon.gymapp.model.login.ModelLogin;
import com.stepon.gymapp.model.ModelRegister;
import com.stepon.gymapp.model.paid.ModelCombo;
import com.stepon.gymapp.model.paid.ModelInd;

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

    @FormUrlEncoded
    @POST("api_file/gym_week.php")
    Call<List<ModelWeek>> getWeek(
            @Field("category_id") String category_id
    );

    @FormUrlEncoded
    @POST("api_file/gym_detail.php")
    Call<List<ModelDetail>> getDetail(
            @Field("week_id") String week_id,
            @Field("category_id") String category_id
    );

 @FormUrlEncoded
    @POST("api_file/gym_day_work.php")
    Call<List<ModelDayWork>> getDayWork(
            @Field("week_id") String week_id,
            @Field("category_id") String category_id,
            @Field("day") String day
    );

 @POST("api_file/gym_diet.php")
    Call<List<ModelDiet>> getDietList();
@POST("api_file/gym_ind.php")
    Call<List<ModelInd>> getIndPcakage();
@POST("api_file/gym_combo.php")
    Call<List<ModelCombo>> getComboPackage();




}
