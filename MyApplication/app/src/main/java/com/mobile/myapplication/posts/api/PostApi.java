package com.mobile.myapplication.posts.api;

import com.mobile.myapplication.posts.models.Posts;

import retrofit2.Call;
import retrofit2.http.GET;
//import retrofit2.http.POST;

public interface PostApi {

    //https://jsonplaceholder.typicode.com/

    @GET("/posts")
    Call<POST> getPosts();
}
