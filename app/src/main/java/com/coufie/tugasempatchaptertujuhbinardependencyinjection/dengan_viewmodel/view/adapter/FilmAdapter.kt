package com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.R
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.model.GetAllFilmItem
import kotlinx.android.synthetic.main.item_film.view.*

class FilmAdapter (private var filmOnClick : (GetAllFilmItem)->Unit) : RecyclerView.Adapter<FilmAdapter.ViewHolder>() {

    private var filmData : List<GetAllFilmItem>? = null

    fun setFilmList(filmList: List<GetAllFilmItem>){
        this.filmData = filmList
    }

    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val uiFilm = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_film, parent, false)

        return ViewHolder(uiFilm)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_film_name.text = "Rp. ${filmData!![position].name.toString()}"
        holder.itemView.tv_film_director.text = "${filmData!![position].director.toString()}"

        this.let {
            Glide.with(holder.itemView.context).load(filmData!![position].image).into(holder.itemView.iv_film_image)
        }

        holder.itemView.filmCard.setOnClickListener {
            filmOnClick(filmData!![position])
        }
    }

    override fun getItemCount(): Int {
        if(filmData == null){
            return 0
        }else{
            return filmData!!.size
        }    }

}