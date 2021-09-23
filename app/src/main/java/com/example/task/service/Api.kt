package com.example.task.service

import com.example.task.model.Post
import com.example.task.model.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("/users")
    fun getUsers(): Call<List<Users>>

    @GET("/posts")
    fun getPosts(@Query("userId") UserId : Int) : Call<List<Post>>

}