package com.example.nowinjetpack.feature.marvel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nowinjetpack.core.common.base.BaseViewModel
import com.example.nowinjetpack.core.domain.DeliveryUseCase
import com.example.nowinjetpack.core.domain.SerieUseCase
import com.example.nowinjetpack.core.model.data.Delivery
import com.example.nowinjetpack.core.model.data.ResultSeries
import com.example.nowinjetpack.core.model.data.ResultSeriesData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MarvelViewModel @Inject constructor(
    private val deliveryUseCase: DeliveryUseCase,
    private val serieUseCase: SerieUseCase
): BaseViewModel() {

    private val _deliveries = MutableLiveData<List<Delivery>>()
    val deliveries: LiveData<List<Delivery>> = _deliveries

    private val _uiSerieState = MutableStateFlow(ResultSeries(data = ResultSeriesData(emptyList())))
    val uiSerieState: StateFlow<ResultSeries> = _uiSerieState

    fun fetchDeliveries() {
        launch() {
            _deliveries.postValue(deliveryUseCase.fetchDeliveries())
        }
    }

    fun fetchSeries() {
        launch2 {
            _uiSerieState.value = serieUseCase.fetchSerie()
        }
    }
}