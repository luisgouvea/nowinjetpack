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
    viewModel: UserViewModel = hiltViewModel()
) {
    //val title by viewModel.uiSerieState.collectAsStateWithLifecycle()
    val title by viewModel.uiUserState.collectAsStateWithLifecycle()
    MarvelScreen(title)
}

@Composable
fun MarvelScreen(text: UserUiState) {
    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            when (text) {
                UserUiState.Loading -> {
                    CircularProgressIndicator()
                }

                is UserUiState.Success -> {
                    text.users?.let { listUsers ->
                        if (listUsers.isNotEmpty()) {
                            val name = listUsers[0].name
                            Text(text = name)
                        }
                    }
                }
            }
        }
    }
}

//@Preview
@Composable
fun MarvelScreenPreview(text: UserUiState) {
    MarvelScreen(text)
}