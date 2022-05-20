package com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.R
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.view.adapter.NewsAdapter
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

//    lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

//        initNewsRecycler()

        getDataNews()

    }

    //menggunakan viewmodel + DI
    fun getDataNews(){

        val newsadapter = NewsAdapter(){
            val pindah = Intent(this, DetailNewsActivity::class.java)
            pindah.putExtra("DETAILNEWS", it)
            startActivity(pindah)
        }

        rv_news.layoutManager = LinearLayoutManager(this)
        rv_news.adapter = newsadapter

        val viewmodle = ViewModelProvider(this).get(NewsViewModel::class.java)
        viewmodle.news.observe(this, {
            if(it!=null){
                newsadapter.setNewsList(it)
                newsadapter.notifyDataSetChanged()

            }
        })
    }



//
//    fun initNewsRecycler(){
//        newsAdapter = NewsAdapter() {
//
//        }
//
//        rv_news.layoutManager = LinearLayoutManager(this)
//        rv_news.adapter = newsAdapter
//
//        initNewsViewModel()
//    }
//
//    fun initNewsViewModel(){
//       val viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
//       viewModel.getLiveDataNewss().observe(this, Observer{
//           if(it != null){
//               newsAdapter.setNewsList(it)
//               newsAdapter.notifyDataSetChanged()
//           }else{
//
//           }
//       })
//       viewModel.getNewsData()
//    }

}