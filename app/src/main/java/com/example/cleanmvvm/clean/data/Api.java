package com.example.cleanmvvm.clean.data;

import com.example.cleanmvvm.clean.model.Movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("movies")
    Call<Movies> getMoviesCall(@Query("page") Integer page);
}
