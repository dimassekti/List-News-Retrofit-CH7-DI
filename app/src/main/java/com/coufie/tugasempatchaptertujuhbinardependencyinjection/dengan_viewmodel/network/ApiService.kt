package com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.network

import com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.model.GetAllNewsItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService{

    //List News
    @GET("news")
    fun getAllNews() : Call<List<GetAllNewsItem>>

}