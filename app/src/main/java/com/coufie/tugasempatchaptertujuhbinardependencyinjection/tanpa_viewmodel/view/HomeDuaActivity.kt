package com.coufie.tugasempatchaptertujuhbinardependencyinjection.tanpa_viewmodel.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.R
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.tanpa_viewmodel.model.GetAllNewsDuaItem
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.tanpa_viewmodel.network.NewsDuaApi
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.tanpa_viewmodel.view.adapter.NewsDuaAdapter
import kotlinx.android.synthetic.main.activity_home_dua.*
import retrofit2.Call
import retrofit2.Response

class HomeDuaActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_dua)

        getNewsData()
    }


    fun getNewsData(){
        NewsDuaApi.instance.getAllNews()
            .enqueue(object : retrofit2.Callback<List<GetAllNewsDuaItem>>{
                override fun onResponse(
                    call: Call<List<GetAllNewsDuaItem>>,
                    response: Response<List<GetAllNewsDuaItem>>
                ) {
                    if(response.isSuccessful){

                        val datanews = response.body()
                        val adapternews = NewsDuaAdapter(datanews!!)
                        val lm = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

                        rv_news_dua.layoutManager = lm
                        rv_news_dua.adapter = adapternews

                    }else{
                        Toast.makeText(this@HomeDuaActivity, "gagal", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<List<GetAllNewsDuaItem>>, t: Throwable) {
                    Toast.makeText(this@HomeDuaActivity, "gagal", Toast.LENGTH_SHORT).show()
                }

            })
    }
}