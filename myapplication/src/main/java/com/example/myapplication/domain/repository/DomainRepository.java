package com.example.myapplication.domain.repository;

import com.example.myapplication.model.Movies;

import io.reactivex.Observable;

public interface DomainRepository {
    Observable<Movies> getMoviesObservable();
}
