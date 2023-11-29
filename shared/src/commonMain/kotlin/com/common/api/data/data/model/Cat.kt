package com.common.api.data.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Cat(
    val id: String? = null,
    val url: String? = null,
    val width: Int? = null,
    val height: Int? = null
)