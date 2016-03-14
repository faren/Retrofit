package com.dromdev.retrofittest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.dromdev.retrofittest.model.Choice;
import com.dromdev.retrofittest.model.Question;
import com.dromdev.retrofittest.model.Vehicle;

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

        initialNetworkService();

        getQuestionChoice();
        postQuestionChoice();

        getVehicle();
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

    private void initialNetworkService(){
        //initialize retrofit
        mRestAdapter = new Retrofit
                .Builder()
                .baseUrl("http://private-9adb36-crashback.apiary-mock.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = mRestAdapter.create(RetrofitRequestService.class);

    }

    private void getQuestionChoice(){
        // call question
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

    private void postQuestionChoice(){

        Question question = new Question();
        question.setQuestion("Siapakah saya?");
        question.setPublished_at("20-03-2016");
        question.setUrl("http://hello.com");

        Call<Question> call = service.createQuestion(question);

        call.enqueue(new Callback<Question>() {
            @Override
            public void onResponse(Call<Question> call, Response<Question> response) {
                System.out.println("Post Response = " + response.code());
                System.out.println("Question = " + response.body().getQuestion());
                System.out.println("URL = " + response.body().getUrl());
                System.out.println("Published at = " + response.body().getPublished_at());

                for(Choice ch: response.body().getChoices()){
                    System.out.println("Choice = " + ch.getChoice());
                    System.out.println("Vote = " + ch.getVotes());
                }

            }

            @Override
            public void onFailure(Call<Question> call, Throwable t) {
                System.out.println(t.getMessage());

            }
        });

    }

    private void getVehicle(){
        // call question
        Call<Vehicle> vehicle= service.vehic();

        //call on another thread not in main thread
        vehicle.enqueue(new Callback<Vehicle>() {
            @Override
            public void onResponse(Call<Vehicle> call, Response<Vehicle> response) {
                System.out.println("Response = " + response.code());
                System.out.println("Response items = " + response.body().getVehicles());

                for (Vehicle.ItemVehicle vh:response.body().getVehicles()) {
                    System.out.println("Vehicle id = " + vh.getId());
                    System.out.println("Vehicle Name = " + vh.getName());
                    System.out.println("Vehicle Height = " + vh.getHeight());
                    System.out.println("Vehicle Length = " + vh.getLength());
                }

            }

            @Override
            public void onFailure(Call<Vehicle> call, Throwable t) {
                System.out.println("failure = " + t.getMessage());
            }
        });
    }
}
