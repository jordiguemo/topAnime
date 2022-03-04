package com.jordiguemo.topanime.domain

import kotlinx.serialization.SerialName

data class Anime(
    val id: String,
    val titles: Title?,
    val synopsis: String?,
    val averageRating: String?,
    val startDate: String?,
    val endDate: String?,
    val popularityRank: Int?,
    val subtype: String?,
    val status: Status?,
    val posterImage: Image?,
    val coverImage: Image?,
    val episodeCount: Int?,
    val episodeLength: Int?,
    val youtubeVideoId: String?,
    val ratingRank: Int?,
    val ageRating: AgeRating?,
    val ageRatingGuide: String?
)

data class Title(
    val en: String?,
    val enJp: String?,
    val jaJp: String?
)

data class Image(
    val tiny: String?,
    val small: String?,
    val medium: String?,
    val large: String?,
    val original: String?
)

enum class Status{
    CURRENT,
    FINISHED,
    TBA,
    UNRELEASED,
    UPCOMING
}

enum class AgeRating{
    G,
    PG,
    R,
    R18
}