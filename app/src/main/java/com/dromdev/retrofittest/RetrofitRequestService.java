package com.dromdev.retrofittest;


import com.dromdev.retrofittest.model.Question;
import com.dromdev.retrofittest.model.Vehicle;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by faren on 5/26/15.
 */
public interface RetrofitRequestService {

    @GET("/questions")
    Call<List<Question>> ques();

    @POST("/questions")
    Call<Question> createQuestion(@Body Question question);

    @PUT("/questions/{id}")
    Call<Question> modifyQuestion(@Path("id")int questionId, @Body Question question);

    @DELETE("/questions/{id}")
    Call<Question> deleteQuestion(@Path("id")int questionId);

    @GET("/vehicles")
    Call<Vehicle> vehic();

    @GET("/v1/vehicles/search")
    Call<Vehicle> searchVehic(
            @Query("searchby") String searchBy,
            @Query("searchbystring") String searchByString,
            @Query("page") int page,
            @Query("paging") int paging);
}
