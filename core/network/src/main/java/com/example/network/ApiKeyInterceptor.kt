package com.example.network

import okhttp3.Interceptor
import okhttp3.Response

internal class ApiKeyInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newBuilder = request.newBuilder()

        newBuilder.addHeader(
            name = "Authorization",
            value = "KakaoAK ${BuildConfig.API_KEY}"
        )

        return chain.proceed(newBuilder.build())
    }
}