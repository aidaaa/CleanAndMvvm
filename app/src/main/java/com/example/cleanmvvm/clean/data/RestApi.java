package com.example.cleanmvvm.clean.data;

import com.example.cleanmvvm.clean.model.Movies;

import io.reactivex.Observable;


public interface RestApi
{
    Observable<Movies> getMoviesObservable();
}
