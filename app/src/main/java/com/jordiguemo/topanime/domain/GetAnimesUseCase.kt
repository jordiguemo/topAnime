package com.jordiguemo.topanime.domain

import javax.inject.Inject


// Business logic. Recibe por parámetro la implementación de un repositorio. Con esa implementación recoge los datos y los devuelve a presentation (sin saber a quién).
class GetAnimesUseCase @Inject constructor(private val animeRepository: AnimeRepository) {
    suspend fun getAnimes(): List<Anime>{
        return animeRepository.getAnimes()
    }
}