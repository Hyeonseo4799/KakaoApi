package com.example.network.api

import com.example.network.dto.KakaoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface KakaoApi {
    @GET("v2/search/image")
    suspend fun searchImage(
        @Query("query") query: String,
        @Query("sort") sort: String = "accuracy",
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 10,
    ): KakaoResponse
}