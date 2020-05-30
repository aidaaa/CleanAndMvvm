package com.example.cleanmvvm.clean.domain.interactor;

import com.example.cleanmvvm.clean.domain.interactor.base.UseCase;
import com.example.cleanmvvm.clean.domain.repository.DomainRepository;
import com.example.cleanmvvm.clean.model.Movies;

import io.reactivex.Observable;

public class GetMoviesUseCase extends UseCase<Movies> {
    DomainRepository domainRepository;

    public GetMoviesUseCase(DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }

    @Override
    public Observable<Movies> buildObservable() {
        return domainRepository.getMoviesObservable();
    }
}
