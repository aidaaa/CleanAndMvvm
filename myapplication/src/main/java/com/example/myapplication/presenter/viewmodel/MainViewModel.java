package com.example.myapplication.presenter.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.data.RepositoryImpl;
import com.example.myapplication.data.RestApiImpl;
import com.example.myapplication.domain.intractor.GetMoviesUseCase;
import com.example.myapplication.model.Movie;
import com.example.myapplication.model.Movies;

import io.reactivex.observers.DisposableObserver;

public class MainViewModel  extends AndroidViewModel {
    MutableLiveData<Movies> mutableLiveData=new MutableLiveData<>();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Movies> getMoviesMutableLiveData()
    {
        RestApiImpl restApi=new RestApiImpl();
        RepositoryImpl repository=new RepositoryImpl(restApi);
        GetMoviesUseCase useCase=new GetMoviesUseCase(repository);
        useCase.execute(new DisposableObserver<Movies>() {
            @Override
            public void onNext(Movies movies) {
                mutableLiveData.postValue(movies);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        return mutableLiveData;
    }
}
