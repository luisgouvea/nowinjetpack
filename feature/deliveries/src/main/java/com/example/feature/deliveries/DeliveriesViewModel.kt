package com.example.feature.deliveries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nowinjetpack.core.common.base.BaseViewModel
import com.example.nowinjetpack.core.domain.DeliveryUseCase
import com.example.nowinjetpack.core.model.data.Delivery


class DeliveriesViewModel(
    private val deliveryUseCase: DeliveryUseCase
): BaseViewModel() {

    private val _deliveries = MutableLiveData<List<Delivery>>()
    val deliveries: LiveData<List<Delivery>> = _deliveries

    fun fetchDeliveries() {
        launch() {
            _deliveries.postValue(deliveryUseCase.fetchDeliveries())
        }
    }
}