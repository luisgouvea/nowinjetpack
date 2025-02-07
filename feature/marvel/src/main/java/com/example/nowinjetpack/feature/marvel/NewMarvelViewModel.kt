package com.example.nowinjetpack.feature.marvel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nowinjetpack.core.domain.SerieUseCaseNew
import com.example.nowinjetpack.core.model.data.ResultSeries
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class NewMarvelViewModel @Inject constructor(
    private val serieUseCaseNew: SerieUseCaseNew
): ViewModel() {

    val uiSerieState: StateFlow<NewsFeedUiState> =
        serieUseCaseNew.fetchSerie()
            .map { NewsFeedUiState.Success(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = NewsFeedUiState.Loading,
            )
}

/**
 * A sealed hierarchy describing the state of the feed of news resources.
 */
sealed interface NewsFeedUiState {
    /**
     * The feed is still loading.
     */
    object Loading : NewsFeedUiState

    /**
     * The feed is loaded with the given list of news resources.
     */
    data class Success(
        /**
         * The list of news resources contained in this feed.
         */
        //val feed: List<ResultSeries>,
        val feed: ResultSeries,
    ) : NewsFeedUiState
}