package com.example.cleanmvvm.clean.data;

import com.example.cleanmvvm.clean.domain.repository.DomainRepository;
import com.example.cleanmvvm.clean.model.Movies;

import io.reactivex.Observable;

public class RepositoryImpl implements DomainRepository {
    @Override
    public Observable<Movies> getMoviesObservable() {
        return new RestApiImpl().getMoviesObservable();
    }
}
