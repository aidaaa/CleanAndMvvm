package com.example.myapplication.domain.intractor;

import com.example.myapplication.domain.repository.DomainRepository;
import com.example.myapplication.model.Movies;

import io.reactivex.Observable;

public class GetMoviesUseCase extends UseCase<Movies> {

    DomainRepository repository;

    public GetMoviesUseCase(DomainRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<Movies> buildObservable() {
        return repository.getMoviesObservable();
    }
}
