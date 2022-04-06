package com.example.countryapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apiinterface {

    @GET("v2/all")
    Call<List<CountryDatum>> getdata();
}
