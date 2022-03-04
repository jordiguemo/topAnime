package com.jordiguemo.topanime.domain

import com.jordiguemo.topanime.domain.GetAnimeByIdUseCase.getById
import org.junit.Assert.*
import org.junit.Test

class GetAnimeByIdUseCaseTest{

    @Test
    fun `given an id I get an Anime`(){
        val animeList: List<Anime> = listOf(giveAnime("1"), giveAnime("2"), giveAnime("3"), giveAnime("4"))
        val animeId = "1"
        val actual = animeList.getById(animeId)
        val expected = giveAnime(animeId)

        assertEquals(expected, actual)
    }

    @Test
    fun `given an id I don't found an Anime`(){
        val animeList: List<Anime> = listOf(giveAnime("1"), giveAnime("2"), giveAnime("3"), giveAnime("4"))
        val animeId = "0"
        val actual = animeList.getById(animeId)
        val expected = null

        assertEquals(expected, actual)
    }

    private fun giveAnime(id: String): Anime{
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