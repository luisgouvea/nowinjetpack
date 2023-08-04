package com.example.nowinjetpack.core.data.model

import com.example.nowinjetpack.core.network.model.ResultSeriesDataResponse
import com.example.nowinjetpack.core.network.model.ResultSeriesResponse

//data class ResultSeriesData(
//    val results: List<SeriesResponse>
//)
data class ResultSeries(
    val data: ResultSeriesDataResponse
)