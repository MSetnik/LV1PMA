package com.example.lv1.Model;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {
    @GET("/v1/courses")
    Call<CourseResponse>GetCourses();
}
