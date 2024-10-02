package com.example.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.data.datasource.KakaoDataSource
import com.example.data.model.toDocument
import com.example.data.paging.KakaoPagingSource
import com.example.model.Document
import com.example.network.dto.DocumentResponse
import com.example.domain.repository.KakaoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class KakaoRepositoryImpl @Inject constructor(
    private val kakaoDataSource: KakaoDataSource
): KakaoRepository {
    override fun searchImage(query: String, sort: String): Flow<PagingData<Document>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                KakaoPagingSource { page ->
                    kakaoDataSource.searchImage(
                        query = query,
                        sort = sort,
                        page = page
                    )
                }
            }
        ).flow.map { pagingData ->
            pagingData.map(DocumentResponse::toDocument)
        }
    }
}