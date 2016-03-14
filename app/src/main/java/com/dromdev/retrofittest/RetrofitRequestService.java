package com.dromdev.retrofittest;


import com.dromdev.retrofittest.model.Question;
import com.dromdev.retrofittest.model.Vehicle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by faren on 5/26/15.
 */
public interface RetrofitRequestService {

    @GET("/questions")
    Call<List<Question>> ques();

    @GET("/vehicles")
    Call<Vehicle> vehic();

    @POST("/questions")
    Call<Question> createQuestion(@Body Question question);

}
