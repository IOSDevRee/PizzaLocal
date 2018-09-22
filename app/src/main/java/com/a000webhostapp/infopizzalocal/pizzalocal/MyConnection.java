package com.a000webhostapp.infopizzalocal.pizzalocal;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

public interface MyConnection {

    @FormUrlEncoded
    @POST("/Registration.php")
    void student_registration(@Field("username") String username,
                              @Field("email") String email,
                              @Field("password") String password,
                              Callback<Response> RESPONSE_CALLBACK

    );

    @GET("/login.php")
    void login(@Query("email") String email,
                @Query("password") String password,
                Callback<Response> RESPONSE_CALLBACK);
}