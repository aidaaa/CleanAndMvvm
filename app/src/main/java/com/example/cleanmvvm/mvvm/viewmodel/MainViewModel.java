package com.example.cleanmvvm.mvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.cleanmvvm.mvvm.doamin.GetMoviesUseCase;
import com.example.cleanmvvm.mvvm.mvvmmodel.Movies;
import com.example.cleanmvvm.mvvm.mvvmmodel.repository.MovieRepository;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {
    MutableLiveData<Movies> moviesLiveData=new MediatorLiveData<>();
    MovieRepository repository;

    public MainViewModel(@NonNull Application application) {
        super(application);
       // repository=new MovieRepository();
       // moviesLiveData=repository.getMoviesMutableLiveData();
    }

    public LiveData<Movies> getMoviesLiveData()
    {
        GetMoviesUseCase getMoviesUseCase=new GetMoviesUseCase();
        getMoviesUseCase.perform()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Movies>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Movies movies) {
                moviesLiveData.postValue(movies);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        return moviesLiveData;
    }
}
