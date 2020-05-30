package com.example.cleanmvvm.clean.domain.repository;

import com.example.cleanmvvm.clean.model.Movies;

import io.reactivex.Observable;

public interface DomainRepository
{
    Observable<Movies> getMoviesObservable();
}
