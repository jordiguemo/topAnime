package com.jordiguemo.topanime.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeAttrDto(
    val titles: TitleDto?,
    val synopsis: String?,
    val averageRating: String?,
    val startDate: String?,
    val endDate: String?,
    val popularityRank: Int?,
    val subtype: String?,
    val status: StatusDto?,
    val posterImage: ImageDto?,
    val coverImage: ImageDto?,
    val episodeCount: Int?,
    val episodeLength: Int?,
    val youtubeVideoId: String?,
    val ratingRank: Int?,
    val ageRating: AgeRatingDto?,
    val ageRatingGuide: String?
)

@Serializable
data class TitleDto(
    val en: String?,
    val enJp: String?,
    val jaJp: String?
)

@Serializable
data class ImageDto(
    val tiny: String?,
    val small: String?,
    val medium: String?,
    val large: String?,
    val original: String?
)

@Serializable
enum class StatusDto{
    CURRENT,
    @SerialName("finished")
    FINISHED,
    TBA,
    UNRELEASED,
    UPCOMING
}

@Serializable
enum class AgeRatingDto{
    G,
    PG,
    R,
    R18
}