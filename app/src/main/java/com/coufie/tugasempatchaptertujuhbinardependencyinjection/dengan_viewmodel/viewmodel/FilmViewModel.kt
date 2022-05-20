package com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.network.ApiService
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.model.GetAllFilmItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmViewModel @Inject constructor(api : ApiService) : ViewModel() {

    private var filmLivedata = MutableLiveData<List<GetAllFilmItem>>()
    val film : LiveData<List<GetAllFilmItem>> = filmLivedata

    init{
        viewModelScope.launch {
            val datafilm = api.getAllFilm()
            delay(
                2000
            )
            filmLivedata.value = datafilm
        }
    }



}