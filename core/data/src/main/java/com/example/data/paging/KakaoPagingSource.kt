package com.example.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.network.dto.DocumentResponse
import com.example.network.dto.KakaoResponse

private const val STARTING_KEY = 1

internal class KakaoPagingSource(
    private val searchImage: suspend (page: Int) -> KakaoResponse,
) : PagingSource<Int, DocumentResponse>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DocumentResponse> {
        val currentPage = params.key ?: 1
        val data = searchImage(currentPage)

        return LoadResult.Page(
            data = data.documents,
            prevKey = if (currentPage == STARTING_KEY) null else currentPage - 1,
            nextKey = if (data.meta.isEnd) null else currentPage + 1
        )
    }

    override fun getRefreshKey(state: PagingState<Int, DocumentResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.let { anchorPage ->
                anchorPage.prevKey?.plus(1) ?: anchorPage.nextKey?.minus(1)
            }
        }
    }
}