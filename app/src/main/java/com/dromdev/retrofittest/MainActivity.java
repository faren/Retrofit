package com.dromdev.retrofittest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.dromdev.retrofittest.model.Choice;
import com.dromdev.retrofittest.model.Question;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    public Retrofit mRestAdapter;
    public RetrofitRequestService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize retrofit
        mRestAdapter = new Retrofit
                .Builder()
                .baseUrl("http://private-92c32-testuser2.apiary-mock.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = mRestAdapter.create(RetrofitRequestService.class);
        Call<List<Question>> call = service.ques();

        //call on another thread not in main thread
        call.enqueue(new Callback<List<Question>>() {
            @Override
            public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
                System.out.println("Response = " + response.code());
                System.out.println("Question = " + response.body().get(0).getQuestion());
                System.out.println("published_at = " + response.body().get(0).getPublished_at());
                System.out.println("url = " + response.body().get(0).getUrl());

                for (Choice ch:response.body().get(0).getChoices()) {
                    System.out.println("choice = " + ch.getChoice());
                    System.out.println("votes = " + ch.getVotes());
                }

            }

            @Override
            public void onFailure(Call<List<Question>> call, Throwable t) {
                System.out.println("failure = " + t.getMessage());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
