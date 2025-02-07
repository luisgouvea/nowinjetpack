package com.example.nowinjetpack.feature.marvel

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.nowinjetpack.marvel.databinding.ActivityMarvelBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

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
        // Start a coroutine in the lifecycle scope
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                with(viewModel) {
                    loading.observe(this@MarvelActivity) { loading ->
                        binding.marvelFlipper.displayedChild = if (loading) SHOW_LOADER else SHOW_CONTENT
                    }
                    deliveries.observe(this@MarvelActivity) {
                        println(it)
                    }
                    uiSerieState.collect {collect ->
                        collect?.data?.results?.let {
                            if (it.isNotEmpty()) {
                                val titleResult = it[0].title
                                binding.tvTest.text = titleResult
                            }

                        }

                    }
                }
            }
        }
    }

    private fun requestSeries() {
        viewModel.fetchSeries()
    }
}