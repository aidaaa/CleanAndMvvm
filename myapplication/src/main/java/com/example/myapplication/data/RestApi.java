package com.example.myapplication.data;

import com.example.myapplication.model.Movies;

import io.reactivex.Observable;

public interface RestApi {
    Observable<Movies> getMoviesObservable();
}
