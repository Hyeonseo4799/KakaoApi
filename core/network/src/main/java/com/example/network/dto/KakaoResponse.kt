package com.example.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KakaoResponse(
    val meta: MetaResponse,
    val documents: List<DocumentResponse>,
)

@Serializable
data class MetaResponse(
    @SerialName("total_count") val totalCount: Int,
    @SerialName("pageable_count") val pageableCount: Int,
    @SerialName("is_end") val isEnd: Boolean,
)

@Serializable
data class DocumentResponse(
    @SerialName("collection") val collection: String,
    @SerialName("thumbnail_url") val thumbnailUrl: String,
    @SerialName("image_url") val imageUrl: String,
    @SerialName("display_sitename") val displaySiteName: String,
    @SerialName("doc_url") val docUrl: String,
    @SerialName("datetime") val datetime: String,
)