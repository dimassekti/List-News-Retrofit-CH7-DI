package com.coufie.tugasempatchaptertujuhbinardependencyinjection.tanpa_viewmodel.network

import com.coufie.tugasempatchaptertujuhbinardependencyinjection.tanpa_viewmodel.model.GetAllNewsDuaItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiDuaService {

    //List News
    @GET("news")
    fun getAllNews() : Call<List<GetAllNewsDuaItem>>
}