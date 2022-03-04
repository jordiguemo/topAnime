package com.jordiguemo.topanime.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.jordiguemo.topanime.data.AnimeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit


@Module // Le dice a @Inject que puede mirar a ver si tiene lo que busca
@InstallIn(SingletonComponent::class) // Tendrá instancia para toda la APP. Solo se podrá instanciar una vez
@ExperimentalSerializationApi
object AnimeNetworkModule {

    private val json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
    }

    @Provides // @Inject buscará si devuelve el tipo que necesita
    fun provideAnimeService(): AnimeService {

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://kitsu.io/api/edge/")
            .client(client)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()

        return retrofit.create(AnimeService::class.java) // Implementa AnimeService (Internamente crea AnimeServiceImpl)
    }
}