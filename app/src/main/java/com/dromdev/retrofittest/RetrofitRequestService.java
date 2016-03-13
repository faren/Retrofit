package com.dromdev.retrofittest;


import com.dromdev.retrofittest.model.Question;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by faren on 5/26/15.
 */
public interface RetrofitRequestService {

    @GET("/questions")
    Call<List<Question>> ques();


}
