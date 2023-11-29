package com.common.api.data.koin_component

import com.common.api.data.data.model.initKoin
import com.common.api.data.data.network.ApiService
import com.common.api.data.data.repository.ApiRepository
import org.koin.core.Koin
import org.koin.core.KoinApplication


fun KoinApplication.Companion.start(): KoinApplication = initKoin()

// get api service instance
val Koin.apiService: ApiService get() = get()

// get post repository instance
val Koin.postRepository: ApiRepository get() = get()

// get cat repository instance
val Koin.catRepository: ApiRepository get() = get()