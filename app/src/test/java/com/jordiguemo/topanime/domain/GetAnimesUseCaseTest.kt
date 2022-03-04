package com.jordiguemo.topanime.domain

import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class GetAnimesUseCaseTest{

    val animeRepository: AnimeRepository = mock(AnimeRepository::class.java) // Simula "mock" instancia de la clase para el testing
    val getAnimeUseCase: GetAnimesUseCase = GetAnimesUseCase(animeRepository)

    @Test
    fun `get Animes from repository`(){
        runBlocking { // Simula una corroutine scope para testing
            val animeList = listOf(generateAnime("1"), generateAnime("2"), generateAnime("3"), generateAnime("4"))
            `when`(animeRepository.getAnimes()).thenReturn(animeList) // Mockea los datos que recogería animeRepository, ya que no se pueden hacer llamadas a apis.
            val actual = getAnimeUseCase.getAnimes()
            val expected: List<Anime> = animeList

            assertEquals(expected, actual)
        }
    }

    private fun generateAnime(id: String): Anime{
        return Anime(
            id,
            Title("asd", "asd", "asd"),
            "asd",
            "asd",
            "asd",
            "asd",
            2,
            "asd",
            Status.CURRENT,
            getImage(),
            getImage(),
            2,
            2,
            "asd",
            2,
            AgeRating.G,
            "awd"
        )
    }

    private fun getImage(): Image{
        return Image("asd", "asd", "asd", "asd", "asd")
    }

}