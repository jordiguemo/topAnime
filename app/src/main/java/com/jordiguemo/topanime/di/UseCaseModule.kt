package com.jordiguemo.topanime.di

import com.jordiguemo.topanime.data.AnimeRepositoryImpl
import com.jordiguemo.topanime.data.AnimeService
import com.jordiguemo.topanime.domain.Anime
import com.jordiguemo.topanime.domain.AnimeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAnimeRepository(animeService: AnimeService): AnimeRepository {
        return AnimeRepositoryImpl(animeService)
    }

}