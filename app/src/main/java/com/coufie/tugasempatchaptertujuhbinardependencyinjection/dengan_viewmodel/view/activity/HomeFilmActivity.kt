package com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.R
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.view.adapter.FilmAdapter
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.viewmodel.FilmViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home_film.*


@AndroidEntryPoint
class HomeFilmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_film)

        getDataFilm()

        favourites()
    }

    fun favourites(){
        fab_favourite.setOnClickListener {
            startActivity(Intent(this, FilmFavouriteActivity::class.java))
        }
    }

    fun getDataFilm(){
        val filmadapter = FilmAdapter(){
            val pindah = Intent(this, DetailFilmActivity :: class.java)
            pindah.putExtra("DETAILFILM", it)
            startActivity(pindah)
        }

        rv_film.layoutManager = LinearLayoutManager(this@HomeFilmActivity)
        rv_film.adapter = filmadapter

        val viewmodell = ViewModelProvider(this@HomeFilmActivity).get(FilmViewModel::class.java)
        viewmodell.film.observe(this@HomeFilmActivity, {
            if(it!=null){
                filmadapter.setFilmList(it)
                filmadapter.notifyDataSetChanged()
            }

        })
    }
}