package com.gasguru.core.network.model.route

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkDuration(
    @Json(name = "text")
    val text: String
)