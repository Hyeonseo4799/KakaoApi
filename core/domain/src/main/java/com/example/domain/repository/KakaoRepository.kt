package com.example.domain.repository

import androidx.paging.PagingData
import com.example.model.Document
import kotlinx.coroutines.flow.Flow

interface KakaoRepository {
    fun searchImage(query: String, sort: String): Flow<PagingData<Document>>
}