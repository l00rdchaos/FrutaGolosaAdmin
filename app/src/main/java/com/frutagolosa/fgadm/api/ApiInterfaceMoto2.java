package com.frutagolosa.fgadm.api;


import com.frutagolosa.fgadm.model.Motorizado;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiInterfaceMoto2 {

    @GET
    Call<List<Motorizado>> getContacts(@Url String url);
}
