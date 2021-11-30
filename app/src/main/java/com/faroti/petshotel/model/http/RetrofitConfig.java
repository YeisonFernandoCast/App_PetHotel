package com.faroti.petshotel.model.http;

import retrofit2.Retrofit;

public class RetrofitConfig {

    //singleton
    private static RetrofitConfig instance;


    public static RetrofitConfig getInstance() {
        if(instance == null){
            instance = new RetrofitConfig();
        }
        return instance;
    }

    private Retrofit retrofit;

    private RetrofitConfig(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}

//TODO clase del 25 noviembre api rest