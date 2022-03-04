package com.jordiguemo.topanime.data.mapper

import com.jordiguemo.topanime.data.model.*
import com.jordiguemo.topanime.data.model.response.GetAnimesResponse
import com.jordiguemo.topanime.domain.*

fun GetAnimesResponse.toAnimeListDomain(): List<Anime>{

    // Cada elemento dentro de la lista (AnimeResponse) lo transforma a AnimeAttrDto
    // Despues volvemos a transformar AnimeAttrDto a Anime
    val animes = this.data.map { it.attributes.toAnimeDomain(it.id) }

    return animes

}

private fun AnimeAttrDto.toAnimeDomain(
    id: String
): Anime{
    return Anime(
        id,
        this.titles?.toTitleDomain(),
        this.synopsis,
        this.averageRating,
        this.startDate,
        this.endDate,
        this.popularityRank,
        this.subtype,
        this.status?.toStatusDomain(),
        this.posterImage?.toTitleDomain(),
        this.coverImage?.toTitleDomain(),
        this.episodeCount,
        this.episodeLength,
        this.youtubeVideoId,
        this.ratingRank,
        this.ageRating?.toAgeRatingDomain(),
        this.ageRatingGuide
    )
}

private fun TitleDto.toTitleDomain(): Title {
    return Title(this.en, this.enJp, this.jaJp)
}

private fun ImageDto.toTitleDomain(): Image{
    return Image(this.tiny, this.small, this.medium, this.large, this.original)
}

private fun StatusDto.toStatusDomain(): Status{
    return Status.valueOf(this.name)
}

private fun AgeRatingDto.toAgeRatingDomain(): AgeRating{
    return AgeRating.valueOf(this.name)
}