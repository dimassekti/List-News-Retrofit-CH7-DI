package com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.model.GetAllNewsItem
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.network.ApiService
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.network.NewsApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named


@HiltViewModel
class NewsViewModel @Inject constructor(api : ApiService) : ViewModel(){


    //menggunakan DI
    private var newsLivedata = MutableLiveData<List<GetAllNewsItem>>()
    val news : LiveData<List<GetAllNewsItem>> = newsLivedata

    init {
        viewModelScope.launch {
            val datanews = api.getAllNewsBaru()
            delay(2000)
            newsLivedata.value = datanews
        }
    }





//    //cara lama
//    lateinit var liveDataNews : MutableLiveData<List<GetAllNewsItem>>
//
//    init {
//        liveDataNews = MutableLiveData()
//    }
//
//    fun getLiveDataNewss() : MutableLiveData<List<GetAllNewsItem>> {
//        return liveDataNews
//    }
//
//    fun getNewsData(){
//        NewsApi.instance.getAllNews()
//            .enqueue(object : retrofit2.Callback<List<GetAllNewsItem>>{
//                override fun onResponse(
//                    call: Call<List<GetAllNewsItem>>,
//                    response: Response<List<GetAllNewsItem>>
//                ) {
//                    if(response.isSuccessful){
//                        liveDataNews.postValue(response.body())
//                    }else{
//                        liveDataNews.postValue((null))
//                    }
//                }
//
//                override fun onFailure(call: Call<List<GetAllNewsItem>>, t: Throwable) {
//                    liveDataNews.postValue(null)
//                }
//
//            })
//    }

}