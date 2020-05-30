package com.example.cleanmvvm.clean.domain.interactor.base;

import com.example.cleanmvvm.clean.domain.interactor.GetMoviesUseCase;
import com.example.cleanmvvm.clean.domain.repository.DomainRepository;

public class UseCaseFactory {

    DomainRepository domainRepository;

    public UseCaseFactory(DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }

    public UseCase getUseCase()
    {
        return new GetMoviesUseCase(domainRepository);
    }
}
