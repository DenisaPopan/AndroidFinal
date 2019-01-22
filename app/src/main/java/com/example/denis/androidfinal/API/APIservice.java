package com.example.denis.androidfinal.API;

import com.example.denis.androidfinal.vo.AccountRequest;
import com.example.denis.androidfinal.vo.AccountResponse;
import com.example.denis.androidfinal.vo.GetTasksRequest;
import com.example.denis.androidfinal.vo.Page;
import com.example.denis.androidfinal.vo.TaskRequest;
import com.example.denis.androidfinal.vo.TaskVO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface APIservice
{
    String MY_URL = "http://192.168.43.190:8080/";

    @POST("users")
    Call<AccountResponse> login(@Body AccountRequest post);

    @POST("tasks")
    Call<Page> getTasks(@Body GetTasksRequest getTasksRequest);

    @PUT("tasks")
    Call<TaskVO> update(@Body TaskRequest taskRequest);

}
