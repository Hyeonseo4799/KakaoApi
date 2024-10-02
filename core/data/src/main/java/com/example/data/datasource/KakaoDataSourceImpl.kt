package com.example.data.datasource

import com.example.network.api.KakaoApi
import com.example.network.dto.KakaoResponse
import javax.inject.Inject

internal class KakaoDataSourceImpl @Inject constructor(
    private val kakaoApi: KakaoApi
): KakaoDataSource {
    override suspend fun searchImage(query: String, sort: String, page: Int): KakaoResponse {
        return kakaoApi.searchImage(query, sort, page)
    }
}