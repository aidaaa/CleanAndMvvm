package com.example.myapplication.presenter.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.data.RepositoryImpl;
import com.example.myapplication.data.RestApiImpl;
import com.example.myapplication.model.Movies;
import com.example.myapplication.presenter.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainViewModel mainViewModel= ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getMoviesMutableLiveData().observe(this, new Observer<Movies>() {
            @Override
            public void onChanged(Movies movies) {
                for (int i = 0; i < movies.data.size(); i++) {
                    System.out.println(movies.data.get(i).id);
                }
            }
        });

    }
}
