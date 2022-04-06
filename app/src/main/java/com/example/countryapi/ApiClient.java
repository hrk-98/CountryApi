package com.example.countryapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String URL="https://restcountries.com/";
    public static Retrofit retrofit;

    public static Retrofit getApiClient(){

        retrofit=new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }

}
