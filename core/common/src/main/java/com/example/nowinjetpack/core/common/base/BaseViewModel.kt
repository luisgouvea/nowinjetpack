package com.example.nowinjetpack.core.common.base


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {

    protected val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean> = _error

    private val _emptyData = MutableLiveData<Boolean>()
    val emptyData: LiveData<Boolean> = _emptyData

    fun launch(disabledLoading: Boolean = false, block: suspend () -> Unit) {
        if (disabledLoading.not())  _loading.postValue(true)

        viewModelScope.launch {
            try {
                block()
            } catch (ex: Exception) {
                _error.postValue(true)
            }

        }
    }

    protected fun launch2(
        enableLoading: Boolean = true,
        errorBlock: ((Throwable) -> Unit?)? = null,
        block: suspend CoroutineScope.() -> Unit
    ) =
        viewModelScope.launch {
            if (enableLoading) _loading.postValue(true)
            runCatching {
                block()
            }
                .onSuccess { if (enableLoading) _loading.postValue(false) }
                .onFailure { error ->
                    if (enableLoading) _loading.postValue(false)
                    if (errorBlock != null) errorBlock.invoke(error)
                    else postErrorValue(error)
                }
        }

    fun postErrorValue(throwable: Throwable) {
        //this.postErrorValue(errorApi, throwable)
    }

}