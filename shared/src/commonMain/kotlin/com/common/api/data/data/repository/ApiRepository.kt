package com.common.api.data.data.repository

import com.common.api.data.common.base.BaseRepository
import com.common.api.data.common.base.execute
import com.common.api.data.data.model.Cat
import com.common.api.data.data.model.Post
import com.common.api.data.data.network.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ApiRepository constructor(private val apiService: ApiService) : BaseRepository() {

    suspend fun getCats() = flow<List<Cat>> { emit(apiService.getCats()) }

    suspend fun getPosts() = safeApiCall { apiService.getPosts() }

    suspend fun getPostForIos(): Flow<List<Post>> = execute { apiService.getPosts() }

    suspend fun getPostTest(): List<Post> = apiService.getPosts()
}