package com.example.myapplication.data;

import com.example.myapplication.domain.repository.DomainRepository;
import com.example.myapplication.model.Movies;

import io.reactivex.Observable;

public class RepositoryImpl implements DomainRepository {

    RestApiImpl restApi;

    public RepositoryImpl(RestApiImpl restApi) {
        this.restApi = restApi;
    }

    @Override
    public Observable<Movies> getMoviesObservable() {
        return restApi.getMoviesObservable();
    }
}
