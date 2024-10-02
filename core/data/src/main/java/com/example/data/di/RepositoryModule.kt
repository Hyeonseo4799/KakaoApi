package com.example.data.di

import com.example.data.repository.KakaoRepositoryImpl
import com.example.domain.repository.KakaoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {
    @Binds
    fun bindsKakaoRepository(
        kakaoRepositoryImpl: KakaoRepositoryImpl
    ): KakaoRepository
}