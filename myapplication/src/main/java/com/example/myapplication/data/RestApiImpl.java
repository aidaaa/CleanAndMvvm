package com.example.myapplication.data;

import com.example.myapplication.model.Movie;
import com.example.myapplication.model.Movies;

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
                if (!e.isDisposed() && movies!=null)
                {
                    e.onNext(movies);
                    e.onComplete();
                }
                else
                    e.onError(new Throwable());
            }
        });
    }

    public Movies getMovies()
    {
        Movies movies=null;
        Api api=ApiService.createApiService("http://moviesapi.ir/api/v1/").getRetrofit().create(Api.class);
        try { movies= api.getMovies(1).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
