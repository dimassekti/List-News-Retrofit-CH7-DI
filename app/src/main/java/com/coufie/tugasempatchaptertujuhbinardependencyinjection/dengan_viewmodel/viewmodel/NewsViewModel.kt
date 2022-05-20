package com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.model.GetAllNewsItem
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.network.NewsApi
import retrofit2.Call
import retrofit2.Response

class NewsViewModel : ViewModel(){


    lateinit var liveDataNews : MutableLiveData<List<GetAllNewsItem>>

    init {
        liveDataNews = MutableLiveData()
    }

    fun getLiveDataNewss() : MutableLiveData<List<GetAllNewsItem>> {
        return liveDataNews
    }

    fun getNewsData(){
        NewsApi.instance.getAllNews()
            .enqueue(object : retrofit2.Callback<List<GetAllNewsItem>>{
                override fun onResponse(
                    call: Call<List<GetAllNewsItem>>,
                    response: Response<List<GetAllNewsItem>>
                ) {
                    if(response.isSuccessful){
                        liveDataNews.postValue(response.body())
                    }else{
                        liveDataNews.postValue((null))
                    }
                }

                override fun onFailure(call: Call<List<GetAllNewsItem>>, t: Throwable) {
                    liveDataNews.postValue(null)
                }

            })
    }

}