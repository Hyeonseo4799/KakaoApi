package com.example.data.di

import com.example.data.datasource.KakaoDataSource
import com.example.data.datasource.KakaoDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataSourceModule {
    @Binds
    fun bindsKakaoDataSource(
        kakaoDataSourceImpl: KakaoDataSourceImpl
    ): KakaoDataSource
}