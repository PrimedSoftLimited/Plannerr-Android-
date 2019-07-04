package com.example.plannerr.api;

import com.example.plannerr.models.ResponseObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {


    @FormUrlEncoded
    @POST("register")
    Call<ResponseObject> register(
            @Field("name") String username,
            @Field("email") String email,
            @Field("phone_number") String phoneNo,
            @Field("password") String password,
            @Field("password_confirmation") String cnfPassword
    );

    @FormUrlEncoded
    @POST("login")
    Call<ResponseObject> login(
            @Field("email") String email,
            @Field("password") String password
    );
}
