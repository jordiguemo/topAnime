package com.jordiguemo.topanime.data

import com.jordiguemo.topanime.data.model.response.GetAnimesResponse
import retrofit2.http.GET

interface AnimeService {
    @GET("anime")
    suspend fun getAnimes(): GetAnimesResponse // Retrofit pone por defecto la función en otro thread, sin necesidad de usar Dispatcher
}