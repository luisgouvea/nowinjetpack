package com.example.nowinjetpack

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.MaterialTheme
import com.example.nowinjetpack.databinding.ActivityMainBinding
import com.example.nowinjetpack.feature.marvel.MarvelActivity
import com.example.nowinjetpack.feature.marvel.MarvelRoute
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

//    Using COMPOSE OR XML
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                MarvelRoute()
            }
        }
    }

//    private lateinit var binding: ActivityMainBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        //val d = vipBenefitsIntent()
//        val d = Intent(this, MarvelActivity::class.java)
//
//        startActivity(d)
//
//    }
}