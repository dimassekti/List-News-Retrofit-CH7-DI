package com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.R
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.room.FilmDatabase
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.view.adapter.AdapterFilmFavourite
import kotlinx.android.synthetic.main.activity_film_favourite.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FilmFavouriteActivity : AppCompatActivity() {

    var filmDb : FilmDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_favourite)

        filmDb = FilmDatabase.getInstance(this)
        getFilmFav()

    }

    fun getFilmFav(){

        rv_favfilm.layoutManager = LinearLayoutManager(this)

        GlobalScope.launch {
            val listFavFilm = filmDb?.filmDao()?.getAllFilm()
            runOnUiThread{
                if(listFavFilm?.size!! < 1){
                    tv.setText("Favourite-ku masing kosong")
                }else{
                    listFavFilm.let {
                        rv_favfilm.adapter = AdapterFilmFavourite(it!!)
                    }
                }
            }
        }
    }
}