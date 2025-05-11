package com.example.nowinjetpack.feature.marvel

import com.example.nowinjetpack.core.domain.SerieUseCase
import com.example.nowinjetpack.core.domain.UserUseCase
import com.example.nowinjetpack.feature.marvel.repository.TestSerieRepository
import com.example.nowinjetpack.feature.marvel.repository.TestUserRepository
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

class UserViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val userRepository = TestUserRepository()

    private val userUseCase = UserUseCase(
        userRepository = userRepository
    )
    private lateinit var viewModel: UserViewModel

    @Before
    fun setup() {
        viewModel = UserViewModel(
            userUseCase = userUseCase,
        )
    }

    @Test
    fun oneBookmark_showsInFeed() = runTest {
        val collectJob = launch(UnconfinedTestDispatcher()) { viewModel.uiUserState.collect() }

        userRepository.getUser()
        val result = viewModel.uiUserState.value
        assertIs<UserUiState.Success>(result)

        collectJob.cancel()
    }
}