package com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.R
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.view.adapter.NewsAdapter
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initNewsRecycler()
    }

    fun initNewsRecycler(){
        newsAdapter = NewsAdapter() {

        }

        rv_news.layoutManager = LinearLayoutManager(this)
        rv_news.adapter = newsAdapter

        initNewsViewModel()
    }

    fun initNewsViewModel(){
       val viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
       viewModel.getLiveDataNewss().observe(this, Observer{
           if(it != null){
               newsAdapter.setNewsList(it)
               newsAdapter.notifyDataSetChanged()
           }else{

           }
       })
       viewModel.getNewsData()
    }

}