package com.jordiguemo.topanime.domain

// Comunicarse con data sin saber nada
interface AnimeRepository {
    suspend fun getAnimes(): List<Anime>
}