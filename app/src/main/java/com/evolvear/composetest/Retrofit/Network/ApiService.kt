package com.evolvear.composetest.Retrofit.Network

import com.evolvear.composetest.Retrofit.Post
import retrofit2.http.GET

interface ApiService {

    companion object{
        const val Base_URL = "https://jsonplaceholder.typicode.com/"
    }

    @GET("posts")
    suspend fun getPosts() : List<Post>
}