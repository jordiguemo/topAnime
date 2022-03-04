package com.jordiguemo.topanime.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jordiguemo.topanime.domain.Anime
import com.jordiguemo.topanime.domain.GetAnimeByIdUseCase.getById
import com.jordiguemo.topanime.domain.GetAnimesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// Le pide al domain lo que necesita, usando el caso de uso
@HiltViewModel
class MainViewModel @Inject constructor(private val getAnimeUseCase: GetAnimesUseCase) : ViewModel() {
    private val animeList: MutableLiveData<List<Anime>> = MutableLiveData<List<Anime>>()
    val animeListLiveData: LiveData<List<Anime>> = animeList

    fun getAnimes() {
        this.viewModelScope.launch {
            runCatching {
                getAnimeUseCase.getAnimes() // '.value' es lo mismo que setValue
            }.onSuccess {
                animeList.value = it
            }.onFailure {
                Log.d("Hola", it.toString())
            }
        }
    }

    fun getAnimeById(animeId: String): Anime? {
        //return GetAnimeByIdUseCase.getAnimeById(animeList.value, animeId)
        return animeList.value.getById(animeId)
    }

}