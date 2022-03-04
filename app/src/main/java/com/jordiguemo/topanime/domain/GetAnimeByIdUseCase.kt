package com.jordiguemo.topanime.domain

object GetAnimeByIdUseCase{
    /*fun getAnimeById(animeList: List<Anime>?, animeId: String): Anime?{
        return animeList?.find { it.id == animeId }
    }*/
    fun List<Anime>?.getById(id: String): Anime?{
        return this?.find { it.id == id }
    }
}