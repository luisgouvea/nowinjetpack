package com.example.nowinjetpack.feature.marvel

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.nowinjetpack.marvel.databinding.ActivityMarvelBinding
import dagger.hilt.android.AndroidEntryPoint

private const val SHOW_CONTENT = 0
private const val SHOW_LOADER = 1

@AndroidEntryPoint
class MarvelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMarvelBinding

    private val viewModel: MarvelViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarvelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewModel()
        requestSeries()
    }

    private fun setUpViewModel() {
        with(viewModel) {
            loading.observe(this@MarvelActivity) { loading ->
                binding.marvelFlipper.displayedChild = if (loading) SHOW_LOADER else SHOW_CONTENT
            }
            deliveries.observe(this@MarvelActivity) {
                println(it)
            }
            serie.observe(this@MarvelActivity) {
                binding.tvTest.text = it.data.results[0].title
            }
        }
    }

    private fun requestSeries() {
        viewModel.fetchSeries()
    }
}