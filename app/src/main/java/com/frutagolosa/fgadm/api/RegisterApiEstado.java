package com.frutagolosa.fgadm.api;
import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
public interface RegisterApiEstado {
    @FormUrlEncoded
    @POST("/CambioDeEstado.php")
    public void inseruser(
            @Field("a") String a,
            @Field("b") String b,
            Callback<Response> callback


    );

}
