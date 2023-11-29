package com.common.api.data

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform