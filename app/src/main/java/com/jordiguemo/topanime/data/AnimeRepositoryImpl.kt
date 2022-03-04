package com.jordiguemo.topanime.data

import com.jordiguemo.topanime.data.mapper.toAnimeListDomain
import com.jordiguemo.topanime.domain.Anime
import com.jordiguemo.topanime.domain.AnimeRepository
import javax.inject.Inject

// Data conoce a domain
// Inject busca en el Module algún Provide que devuelve AnimeService, en este caso AnimeNetworkModule
class AnimeRepositoryImpl @Inject constructor(private val animeService: AnimeService): AnimeRepository {
    override suspend fun getAnimes(): List<Anime> {
        val serviceResponse = animeService.getAnimes()
        return serviceResponse.toAnimeListDomain()
    }
}