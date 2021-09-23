package com.example.task.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.task.model.Post
import com.example.task.service.ApiServis
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class PostViewModel : ViewModel() {

    private val apiServis = ApiServis()

    val posts = MutableLiveData<List<Post>>()

    fun getPost(gettingId : Int){
        val response = apiServis.getData(gettingId)


        response.enqueue(object  : retrofit2.Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>>,
                                    response: Response<List<Post>>){
                if(response.isSuccessful)
                    posts.value= response.body()
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
            }
        })

    }


}