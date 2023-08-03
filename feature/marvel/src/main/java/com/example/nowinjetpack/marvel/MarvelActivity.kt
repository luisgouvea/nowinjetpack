package com.example.nowinjetpack.marvel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nowinjetpack.marvel.databinding.ActivityMarvelBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MarvelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMarvelBinding

    private val viewModel: MarvelViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarvelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewModel()
    }

    private fun setUpViewModel() {
        viewModel.deliveries.observe(this) {
            println(it)
        }
        viewModel.fetchDeliveries()
    }
}