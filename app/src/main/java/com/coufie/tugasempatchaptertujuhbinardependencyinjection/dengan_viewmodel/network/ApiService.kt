package com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.network

import com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.model.GetAllNewsItem
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.model.GetAllFilmItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService{

    //List News
    @GET("news")
    fun getAllNews() : Call<List<GetAllNewsItem>>

    //List News
    @GET("news")
    suspend fun getAllNewsBaru() : List<GetAllNewsItem>

    @GET("film")
    suspend fun getAllFilm() : List<GetAllFilmItem>

}