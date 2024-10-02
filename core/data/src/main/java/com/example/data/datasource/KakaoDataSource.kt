package com.example.data.datasource

import com.example.network.dto.KakaoResponse

internal interface KakaoDataSource {
    suspend fun searchImage(query: String, sort: String, page: Int): KakaoResponse
}