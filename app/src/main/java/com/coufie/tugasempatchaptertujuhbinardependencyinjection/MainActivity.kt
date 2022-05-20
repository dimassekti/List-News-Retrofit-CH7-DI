package com.coufie.tugasempatchaptertujuhbinardependencyinjection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.view.activity.HomeActivity
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.tanpa_viewmodel.view.HomeDuaActivity
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.view.activity.HomeFilmActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Handler(Looper.getMainLooper()).postDelayed({
//            startActivity(Intent(this, HomeActivity::class.java))
//        }, 3000)

        tanpa_vm.setOnClickListener {
            startActivity(Intent(this, HomeDuaActivity::class.java))
        }

        dengan_vm.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        tugas_film.setOnClickListener {
            startActivity(Intent(this, HomeFilmActivity::class.java))
        }
    }
}