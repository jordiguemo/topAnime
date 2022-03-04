package com.jordiguemo.topanime.data.model.response

import com.jordiguemo.topanime.data.model.AnimeAttrDto
import kotlinx.serialization.Serializable

@Serializable
data class GetAnimesResponse(
    val data: List<AnimeResponse>
)

@Serializable
data class AnimeResponse(
    val id: String,
    val attributes: AnimeAttrDto
)