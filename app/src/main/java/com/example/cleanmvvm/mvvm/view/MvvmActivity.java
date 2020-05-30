package com.example.cleanmvvm.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.cleanmvvm.R;
import com.example.cleanmvvm.mvvm.mvvmmodel.Movies;
import com.example.cleanmvvm.mvvm.viewmodel.MainViewModel;

public class MvvmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm);
        MainViewModel mainViewModel= ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getMoviesLiveData().observe(this, new Observer<Movies>() {
            @Override
            public void onChanged(Movies movies) {
                for (int i = 0; i < movies.data.size(); i++) {
                    System.out.println(movies.data.get(i).id);
                }
            }
        });
    }
}
