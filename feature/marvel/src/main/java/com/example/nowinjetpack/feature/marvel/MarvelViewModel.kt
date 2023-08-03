package com.example.nowinjetpack.feature.marvel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nowinjetpack.core.common.base.BaseViewModel
import com.example.nowinjetpack.core.domain.DeliveryUseCase
import com.example.nowinjetpack.core.domain.SerieUseCase
import com.example.nowinjetpack.core.model.data.Delivery
import com.example.nowinjetpack.core.model.data.Serie


class MarvelViewModel(
    private val deliveryUseCase: DeliveryUseCase,
    private val serieUseCase: SerieUseCase
): BaseViewModel() {

    private val _deliveries = MutableLiveData<List<Delivery>>()
    val deliveries: LiveData<List<Delivery>> = _deliveries

    private val _serie = MutableLiveData<List<Serie>>()
    val serie: LiveData<List<Serie>> = _serie

    fun fetchDeliveries() {
        launch() {
            _deliveries.postValue(deliveryUseCase.fetchDeliveries())
        }
    }

    fun fetchSeries() {
        launch {
            //_serie.postValue(serieUseCase.fetchSerie())
            serieUseCase.fetchSerie()
        }
    }
}