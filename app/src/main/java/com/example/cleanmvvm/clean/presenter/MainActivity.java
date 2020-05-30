package com.example.cleanmvvm.clean.presenter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;

import com.example.cleanmvvm.R;
import com.example.cleanmvvm.clean.model.Movies;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MutableLiveData<Movies> liveData=new MutableLiveData<>();
        liveData.observe(this, new Observer<Movies>() {
            @Override
            public void onChanged(Movies movies) {
                for (int i = 0; i < movies.data.size(); i++) {
                    System.out.println(movies.data.get(i).getId());
                }
            }
        });
    }
}
