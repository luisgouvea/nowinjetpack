package com.example.nowinjetpack.feature.marvel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.getValue

@Composable
fun MarvelRoute(
    viewModel: MarvelViewModel = hiltViewModel()
) {
    val title by viewModel.uiSerieState.collectAsStateWithLifecycle()
    MarvelScreen(title)
}

@Composable
fun MarvelScreen(text: NewsFeedUiState) {
    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            when (text) {
                NewsFeedUiState.Loading -> {
                    CircularProgressIndicator()
                }

                is NewsFeedUiState.Success -> {
                    text.feed?.data?.let { listSeries ->
                        if (listSeries.isNotEmpty()) {
                            val title = listSeries[0].title
                            Text(text = title)
                        }
                    }
                }
            }
        }
    }
}

//@Preview
@Composable
fun MarvelScreenPreview(text: NewsFeedUiState) {
    MarvelScreen(text)
}