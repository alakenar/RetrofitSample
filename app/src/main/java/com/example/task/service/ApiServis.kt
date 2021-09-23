package com.example.task.service

import com.example.task.model.Post
import com.example.task.model.Users
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiServis {

    private val BASE_URL = "http://jsonplaceholder.typicode.com"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Api::class.java)

    fun getData(): Call<List<Users>> {
        return api.getUsers()

    }

    fun getData(postId : Int): Call<List<Post>> {
        return api.getPosts(postId)
    }
}