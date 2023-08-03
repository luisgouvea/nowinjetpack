package com.example.nowinjetpack.feature.marvel

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
        viewModel.fetchSeries()
    }

    private fun setUpViewModel() {
        with(viewModel) {
            deliveries.observe(this@MarvelActivity) {
                println(it)
            }
            serie.observe(this@MarvelActivity) {
                println(it)
            }
        }
    }
}