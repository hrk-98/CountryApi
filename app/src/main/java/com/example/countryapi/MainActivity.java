package com.example.countryapi;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    public final String URL="https://restcountries.com/v2/all";
    RecyclerView list;
    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.list);

        Apiinterface apiinterface=ApiClient.getApiClient().create(Apiinterface.class);
        apiinterface.getdata().enqueue(new Callback<List<CountryDatum>>() {

            @Override
            public void onResponse(Call<List<CountryDatum>> call, Response<List<CountryDatum>> response) {

                    List<CountryDatum> modellist=response.body();
                    adapter = new RecyclerAdapter(MainActivity.this,modellist);
                    list.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    list.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<CountryDatum>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Data is failed = "+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}