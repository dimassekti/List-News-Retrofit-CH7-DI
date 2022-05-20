package com.coufie.tugasempatchaptertujuhbinardependencyinjection.tanpa_viewmodel.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.R
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.tanpa_viewmodel.model.GetAllNewsDuaItem
import kotlinx.android.synthetic.main.item_news.view.*

class NewsDuaAdapter(private var newsData : List<GetAllNewsDuaItem>? = null) : RecyclerView.Adapter<NewsDuaAdapter.ViewHolder>() {



    fun setNewsList(newsList: List<GetAllNewsDuaItem>){
        this.newsData = newsList
    }

    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val uiNews = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)

        return ViewHolder(uiNews)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_news_author.text = "Rp. ${newsData!![position].author.toString()}"
        holder.itemView.tv_news_title.text = "${newsData!![position].title.toString()}"

        this.let {
            Glide.with(holder.itemView.context).load(newsData!![position].image).into(holder.itemView.iv_news_image)
        }
    }

    override fun getItemCount(): Int {
        if(newsData == null){
            return 0
        }else{
            return newsData!!.size
        }
    }

}