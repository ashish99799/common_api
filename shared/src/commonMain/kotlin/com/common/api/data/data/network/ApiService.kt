package com.common.api.data.data.network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import com.common.api.data.data.model.*

class ApiService(private val client: HttpClient) {

    private val baseUrl: String = "https://jsonplaceholder.typicode.com"
    private val catUrl = "https://api.thecatapi.com/v1/images/search?limit=20"

    suspend fun getPosts(): List<Post> {
        return client.get { url("$baseUrl/posts") }.body()
    }

    suspend fun getCats(): List<Cat> {
        return client.get { url(catUrl) }.body()
    }

}