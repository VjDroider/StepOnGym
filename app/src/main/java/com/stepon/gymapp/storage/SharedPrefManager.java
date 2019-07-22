package com.stepon.gymapp.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.stepon.gymapp.utils.Constant;

public class SharedPrefManager {
    private static SharedPrefManager mInstance;
    private Context tContext;

    private SharedPreferences.Editor tEditor;


    public SharedPrefManager(Context tContext) {
        this.tContext = tContext;
    }

    public static synchronized SharedPrefManager getInstance(Context tCtx){
        if (mInstance == null){
            mInstance = new SharedPrefManager(tCtx);

        }
        return mInstance;
    }

    public void setUserData( String userId, String userName , String phoneNo , String email , String dob ,
                             String doj) {
        SharedPreferences tSharedPreferences = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
        tEditor = tSharedPreferences.edit();
        tEditor.putString(Constant.USER_ID, userId);
        tEditor.putString(Constant.USER_NAME, userName);
        tEditor.putString(Constant.USER_DOB, dob);
        tEditor.putString(Constant.USER_MOBILE, phoneNo);
        tEditor.putString(Constant.USER_EMAIL, email);
        tEditor.putString(Constant.USER_DOJ, doj);
        tEditor.apply();

    }


    public void clearUserData(){
        SharedPreferences tPref = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
        tEditor = tPref.edit();

        tEditor.remove(Constant.USER_ID);
        tEditor.remove(Constant.USER_NAME);
        tEditor.remove(Constant.USER_DOB);
        tEditor.remove(Constant.USER_MOBILE);
        tEditor.remove(Constant.USER_EMAIL);
        tEditor.remove(Constant.USER_DOJ);
        tEditor.apply();
        tEditor.clear();
    }









    public String getUserId(){
        SharedPreferences sp = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
        return sp.getString(Constant.USER_ID, Constant.EMPTY);
    }
    public String getUserName(){
        SharedPreferences sp = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
        return sp.getString(Constant.USER_NAME, Constant.EMPTY);
    }
    public String getUserDob(){
        SharedPreferences sp = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
        return sp.getString(Constant.USER_DOB, Constant.EMPTY);
    }
    public String getUserMobile(){
        SharedPreferences sp = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
        return sp.getString(Constant.USER_MOBILE, Constant.EMPTY);
    }
    public String getUserEmail(){
        SharedPreferences sp = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
        return sp.getString(Constant.USER_EMAIL, Constant.EMPTY);
    }

    public String getUserDoj(){
        SharedPreferences sp = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
        return sp.getString(Constant.USER_DOJ, Constant.EMPTY);
    }
    public String getUserProPic(){
        SharedPreferences sp = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
        return sp.getString(Constant.USER_PRO_PIC, Constant.EMPTY);
    }

}