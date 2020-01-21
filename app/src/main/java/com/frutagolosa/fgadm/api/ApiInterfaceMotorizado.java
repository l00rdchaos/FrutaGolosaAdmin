package com.frutagolosa.fgadm.api;

import com.frutagolosa.fgadm.model.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterfaceMotorizado {


    @GET("ListarMotorizado.php")
    Call<List<Contact>> getMotorizados();
}
