package com.frutagolosa.fgadm.api;


import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface RegisterAPI {

    @FormUrlEncoded
    @POST("/UpdateModificar.php")
    public void inseruser(
            @Field("a") String a,
            @Field("b") String b,
            @Field("c") String c,
            @Field("d") String d,
            @Field("e") String e,
            @Field("f") String f,
            @Field("g") String g,
            @Field("h") String h,
            @Field("i") String i,
            @Field("j") String j,
            @Field("k") String k,
            @Field("l") String l,
            @Field("m") String m,
            @Field("n") String n,
            @Field("o") String o,
            @Field("p") String p,
            @Field("q") String q,
            @Field("r") String r,
            Callback<Response> callback


    );

}
