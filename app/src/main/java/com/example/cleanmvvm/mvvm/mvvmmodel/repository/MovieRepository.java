package com.example.cleanmvvm.mvvm.mvvmmodel.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.cleanmvvm.mvvm.mvvmmodel.Movie;
import com.example.cleanmvvm.mvvm.mvvmmodel.Movies;
import com.example.cleanmvvm.mvvm.mvvmmodel.net.Api;
import com.example.cleanmvvm.mvvm.mvvmmodel.net.ApiService;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MovieRepository {

    public static MovieRepository movieRepository;
    Api api;
    Retrofit retrofit;
    private MutableLiveData<Movies> moviesMutableLiveData=new MutableLiveData<>();

    public static MovieRepository getInstance()
    {
        if (movieRepository==null)
            movieRepository=new MovieRepository();
        return movieRepository;
    }

    public MovieRepository() {
        api= ApiService.createApiService("http://moviesapi.ir/api/v1/").getRetrofit().create(Api.class);
       // api=retrofit.create(Api.class);
    }

    public MutableLiveData<Movies> getMoviesMutableLiveData()
    {
        api.getMoviesCall(1).enqueue(new Callback<com.example.cleanmvvm.mvvm.mvvmmodel.Movies>() {
            @Override
            public void onResponse(Call<com.example.cleanmvvm.mvvm.mvvmmodel.Movies> call, Response<com.example.cleanmvvm.mvvm.mvvmmodel.Movies> response) {
                Movies movies=response.body();
                moviesMutableLiveData.postValue(movies);
            }

            @Override
            public void onFailure(Call<com.example.cleanmvvm.mvvm.mvvmmodel.Movies> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
        return moviesMutableLiveData;
    }

    public Observable<Movies> getMoviesObservable()
    {
       return Observable.create(new ObservableOnSubscribe<Movies>() {
            @Override
            public void subscribe(ObservableEmitter<Movies> e) throws Exception {
                Movies movies=getMovies();
                if (movies!= null && !e.isDisposed())
                {
                    e.onNext(movies);
                    e.onComplete();
                }
                else e.onError(new Exception());
            }
        });

    }

    public Movies getMovies()
    {
        Movies movies=new Movies();
        try {
            movies=api.getMoviesCall(1).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
return movies;
    }
}
