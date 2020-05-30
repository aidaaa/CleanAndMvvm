package com.example.cleanmvvm.mvvm.doamin;

import com.example.cleanmvvm.mvvm.mvvmmodel.Movies;
import com.example.cleanmvvm.mvvm.mvvmmodel.repository.MovieRepository;

import io.reactivex.Observable;

public class GetMoviesUseCase extends BaseUseCase {
    MovieRepository repository=new MovieRepository();

    @Override
    public Observable<Movies> perform() {
        return repository.getMoviesObservable();
    }
}
