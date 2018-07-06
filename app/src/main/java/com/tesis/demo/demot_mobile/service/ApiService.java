package com.tesis.demo.demot_mobile.service;

import com.tesis.demo.demot_mobile.model.Alumno;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    String API_BASE_URL = "https://demot-wm-gustavoch25.c9users.io";

    @FormUrlEncoded
    @POST("/api/v1/login")
    Call<Alumno> correo(
            @Field("correo") String login,
            @Field("password") String password
    );

}
