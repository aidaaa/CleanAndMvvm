package com.example.cleanmvvm.clean.presenter;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cleanmvvm.clean.model.Movies;

import io.reactivex.observers.DisposableObserver;

public class Presenter extends ViewModel {

    MutableLiveData<Movies> liveData;

    public Presenter() {
        liveData=new MutableLiveData<>();
    }

    public MutableLiveData<Movies> getLiveData(){
        DisposableObserver<Movies> observer=new DisposableObserver<Movies>() {
            @Override
            public void onNext(Movies movies) {
                liveData.setValue(movies);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        return liveData;
    }
}
