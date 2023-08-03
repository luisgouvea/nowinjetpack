package com.example.nowinjetpack

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.core.common.route.vipBenefitsIntent
import com.example.nowinjetpack.databinding.ActivityMainBinding
import com.example.nowinjetpack.marvel.MarvelActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val d = vipBenefitsIntent()
        val d = Intent(this, MarvelActivity::class.java)

        startActivity(d)

    }
}