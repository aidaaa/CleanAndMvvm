package com.example.cleanmvvm.mvvm.doamin;

import com.example.cleanmvvm.mvvm.mvvmmodel.Movies;

import io.reactivex.Observable;

public abstract class BaseUseCase {
    public abstract Observable<Movies> perform();
}
