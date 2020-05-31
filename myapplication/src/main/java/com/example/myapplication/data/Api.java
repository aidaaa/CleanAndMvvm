package com.example.myapplication.data;


import com.example.myapplication.model.Movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("movies")
    Call<Movies> getMovies(@Query("page") Integer page);
}
