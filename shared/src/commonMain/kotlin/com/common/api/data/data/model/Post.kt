package com.common.api.data.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val id: Int,
    val body: String
)