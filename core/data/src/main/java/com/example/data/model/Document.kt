package com.example.data.model

import com.example.model.Document
import com.example.network.dto.DocumentResponse

internal fun DocumentResponse.toDocument() = Document(
    collection = collection,
    thumbnailUrl = thumbnailUrl,
    imageUrl = imageUrl,
    displaySiteName = displaySiteName,
    docUrl = docUrl,
    datetime = datetime,
)