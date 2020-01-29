package com.example.projectapp.Interface;

import com.example.projectapp.Model.Carrier;
import com.example.projectapp.Model.Client;
import com.example.projectapp.Model.Product;
import com.example.projectapp.Model.Zone;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Transport {

    @GET("getcarriers")
    Call<List<Carrier>> getCarriers();
    @GET("getproducts")
    Call<List<Product>> getProducts();
    @GET("zones")
    Call<List<Zone>> getZones();
    @GET("clients")
    Call<List<Client>> getClients();
}

