package com.example.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.domain.usecase.SearchImageUseCase
import com.example.model.Document
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val searchImageUseCase: SearchImageUseCase
): ViewModel() {
    fun searchImage(query: String, sort: String = "accuracy"): Flow<PagingData<Document>> {
        return searchImageUseCase(query, sort).cachedIn(viewModelScope)
    }
}