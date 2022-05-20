package com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.R
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.model.GetAllNewsItem
import kotlinx.android.synthetic.main.activity_detail_news.*

class DetailNewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)


        val detailNews = intent.getParcelableExtra<GetAllNewsItem>("DETAILNEWS")

        val title = detailNews!!.title
        val isi = detailNews!!.description
//
        tv_title.text = title

    }



}