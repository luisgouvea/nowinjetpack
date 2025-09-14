package com.example.nowinjetpack.feature.marvel

import com.example.nowinjetpack.core.domain.SerieUseCase
import com.example.nowinjetpack.feature.marvel.repository.TestSerieRepository
import com.example.nowinjetpack.feature.marvel.util.MainDispatcherRule
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.flow.collect
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class MarvelViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val serieRepository = TestSerieRepository()

    private val serieUseCase = SerieUseCase(
        serieRepository = serieRepository
    )
    private lateinit var viewModel: MarvelViewModel

    @Before
    fun setup() {
        viewModel = MarvelViewModel(
            serieUseCase = serieUseCase,
        )
    }

    @Test
    fun stateIsInitiallyLoading() = runTest {
        assertEquals(
            NewsFeedUiState.Loading,
            viewModel.uiSerieState.value,
        )
        assertEquals(NewsFeedUiState.Loading, viewModel.uiSerieState.value)
    }

    @Test
    fun oneBookmark_showsInFeed() = runTest {
        val collectJob = launch(UnconfinedTestDispatcher()) { viewModel.uiSerieState.collect() }

        serieRepository.fetchSerie(3)
        val result = viewModel.uiSerieState.value
        assertIs<NewsFeedUiState.Success>(result)

        collectJob.cancel()
    }


//    @Test
//    fun recentSearches_verifyUiStateIsSuccess() = runTest {
//        val collectJob = launch(UnconfinedTestDispatcher()) { viewModel.recentSearchQueriesUiState.collect() }
//        viewModel.onSearchTriggered("kotlin")
//
//        val result = viewModel.recentSearchQueriesUiState.value
//        assertIs<Success>(result)
//
//        collectJob.cancel()
//    }

//    @Test
//    fun oneBookmark_showsInFeed() = runTest {
//        val collectJob = launch(UnconfinedTestDispatcher()) { viewModel.feedUiState.collect() }
//
//        newsRepository.sendNewsResources(newsResourcesTestData)
//        userDataRepository.updateNewsResourceBookmark(newsResourcesTestData[0].id, true)
//        val item = viewModel.feedUiState.value
//        assertIs<Success>(item)
//        assertEquals(item.feed.size, 1)
//
//        collectJob.cancel()
//    }
}