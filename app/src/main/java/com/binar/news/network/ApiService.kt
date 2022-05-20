package com.binar.news.network


import com.binar.news.model.GetAllNewsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("news")
    fun getAllNews() : Call<List<GetAllNewsResponse>>
}