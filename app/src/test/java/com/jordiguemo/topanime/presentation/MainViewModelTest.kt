package com.jordiguemo.topanime.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jordiguemo.topanime.domain.Anime
import com.jordiguemo.topanime.domain.AnimeRepository
import com.jordiguemo.topanime.domain.GetAnimesUseCase
import com.jordiguemo.topanime.utils.generateAnime
import com.jordiguemo.topanime.utils.test
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

@ExperimentalCoroutinesApi
class MainViewModelTest{

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    private val animeRepository: AnimeRepository = mock(AnimeRepository::class.java) // Simula "mock" instancia de la clase para el testing
    private val getAnimeUseCase: GetAnimesUseCase = GetAnimesUseCase(animeRepository)
    private val mainViewModel: MainViewModel = MainViewModel(getAnimeUseCase)
    private val dispatcher = UnconfinedTestDispatcher() // Para que no cree conflicto con el .launch{} del viewModel. Me abre un thread para el test.

    @Before // Ejecuta automáticamente esta función antes de cada test
    fun setup() {
        Dispatchers.setMain(dispatcher)
    }

    @After // Ejecuta automáticamente esta función después de cada test
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `get Animes`(){
        val animeList: List<Anime> = listOf(generateAnime("1"), generateAnime("2"), generateAnime("3"), generateAnime("4"))
        val observer = mainViewModel.animeListLiveData.test()
        runBlocking {
            `when`(animeRepository.getAnimes()).thenReturn(animeList)
            mainViewModel.getAnimes()
            val expected: List<Anime> = animeList
            observer.assertLastValue(expected)
        }
    }

}