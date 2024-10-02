package com.example.domain.usecase

import androidx.paging.PagingData
import com.example.model.Document
import com.example.domain.repository.KakaoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchImageUseCase @Inject constructor(
    private val kakaoRepository: KakaoRepository
) {
    operator fun invoke(query: String, sort: String): Flow<PagingData<Document>> {
        return kakaoRepository.searchImage(query = query, sort = sort)
    }
}