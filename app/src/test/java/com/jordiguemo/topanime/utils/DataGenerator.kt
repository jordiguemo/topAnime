package com.jordiguemo.topanime.utils

import com.jordiguemo.topanime.domain.*

fun generateAnime(id: String): Anime {
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

private fun getImage(): Image {
    return Image("asd", "asd", "asd", "asd", "asd")
}