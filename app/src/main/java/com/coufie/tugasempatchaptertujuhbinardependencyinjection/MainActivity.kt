package com.coufie.tugasempatchaptertujuhbinardependencyinjection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.R
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.view.activity.HomeActivity
import com.coufie.tugasempatchaptertujuhbinardependencyinjection.tanpa_viewmodel.view.HomeDuaActivity
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
    }
}