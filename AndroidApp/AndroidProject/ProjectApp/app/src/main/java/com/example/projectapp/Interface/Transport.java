package com.example.projectapp.Interface;

import com.example.projectapp.Model.Carrier;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Transport {

    @GET("getcarriers")
    Call<List<Carrier>> getCarriers();
}

