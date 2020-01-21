package com.frutagolosa.fgadm.api;


import com.frutagolosa.fgadm.model.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiInterface {

    @GET
    Call<List<Contact>> getContacts(@Url String url);
}