package com.jordiguemo.topanime.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jordiguemo.topanime.R
import com.jordiguemo.topanime.databinding.FragmentAnimeListBinding
import com.jordiguemo.topanime.domain.Anime
import com.jordiguemo.topanime.presentation.MainViewModel

class AnimeListFragment: Fragment() {

    private var binding: FragmentAnimeListBinding? = null
    //private val mainViewModel: MainViewModel by viewModels() // Vincula el ciclo de vida del viewmodel a él mismo
    private val mainViewModel: MainViewModel by activityViewModels() // Coge la instancia del viewmodel de su activity (MainActivity)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnimeListBinding.inflate(inflater, container, false)
        val view = binding?.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //mainViewModel.animeListLiveData.observe(this, ::renderList)
        //mainViewModel.animeListLiveData.observe(this, { animeList -> renderList(animeList) })
        mainViewModel.animeListLiveData.observe(this, { renderList(it) })
        mainViewModel.getAnimes()
    }

    private fun renderList(list: List<Anime>){
        // Cómo implementar RecyclerView
        val animeAdapter = AnimeAdapter(::onAnimeClicked)
        animeAdapter.animes = list
        binding?.animeList?.adapter = animeAdapter
    }
    private fun onAnimeClicked(animeId: String){
        // La libreríra Navigation autogenera una clase con el id del fragment que tiene la acción, con la acción como función.
        findNavController().navigate(AnimeListFragmentDirections.toAnimeDetailFragment(animeId))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}