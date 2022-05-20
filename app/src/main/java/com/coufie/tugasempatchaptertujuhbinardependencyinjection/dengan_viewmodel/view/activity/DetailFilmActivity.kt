package com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.R
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.model.GetAllFilmItem
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.room.Film
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.room.FilmDatabase
import kotlinx.android.synthetic.main.activity_detail_film.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class DetailFilmActivity : AppCompatActivity() {

    var filmfavdb : FilmDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_film)

        filmfavdb = FilmDatabase.getInstance(this)

        val detailFilm = intent.getParcelableExtra<GetAllFilmItem>("DETAILFILM")

        val name = detailFilm!!.name
        val image = detailFilm!!.image
        val director = detailFilm!!.director
        val decription = detailFilm!!.description

        Glide.with(this).load(detailFilm!!.image).into(iv_detail_film_image)
        tv_detail_film_name.text = name
        tv_detail_film_director.text = director
        tv_detail_film_decription.text = decription


        iv_addfavfilm.setOnClickListener{

            GlobalScope.async {

                val detailFilm = intent.getParcelableExtra<GetAllFilmItem>("DETAILFILM")

                val director = detailFilm!!.director
                val releasedate = detailFilm!!.date
                val synopsis = detailFilm!!.description
                val title = detailFilm!!.name
                val image = detailFilm!!.image
                val id = detailFilm!!.id

                runOnUiThread {
                    var checkdata = filmfavdb?.filmDao()?.insertNote(Film(id.toInt(), director, image, releasedate, synopsis, title) )
                    if(checkdata != 0.toLong()){
                        Toast.makeText(this@DetailFilmActivity, "Film Ditambahkan Ke Favourite", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@DetailFilmActivity, "gagal", Toast.LENGTH_SHORT).show()
                    }

                    Log.d("tes2", checkdata.toString())
                }

            }
        }

    }

}