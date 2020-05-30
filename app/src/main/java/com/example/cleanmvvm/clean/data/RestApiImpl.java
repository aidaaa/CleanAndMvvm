package com.example.cleanmvvm.clean.data;

import com.example.cleanmvvm.clean.model.Movies;
import com.example.cleanmvvm.clean.data.ApiService;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class RestApiImpl implements RestApi {
    @Override
    public Observable<Movies> getMoviesObservable() {
        return Observable.create(new ObservableOnSubscribe<Movies>() {
            @Override
            public void subscribe(ObservableEmitter<Movies> e) throws Exception {
                    Movies movies=getMovies();
                    if (movies!=null && !e.isDisposed()) {
                        e.onNext(movies);
                        e.onComplete();
                    }
                    else
                        e.onError(new Exception());
            }
        });
    }

    public Movies getMovies()
    {
        Api api=ApiService.createApiService("http://moviesapi.ir/api/v1/").getRetrofit().create(Api.class);
        try {
            return api.getMoviesCall(1).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
