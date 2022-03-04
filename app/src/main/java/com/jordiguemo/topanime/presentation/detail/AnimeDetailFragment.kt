package com.jordiguemo.topanime.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.jordiguemo.topanime.databinding.FragmentAnimeDetailBinding
import com.jordiguemo.topanime.presentation.MainViewModel
import com.squareup.picasso.Picasso

class AnimeDetailFragment: Fragment() {

    private var binding: FragmentAnimeDetailBinding? = null
    private val mainViewModel: MainViewModel by activityViewModels()
    private val args: AnimeDetailFragmentArgs by navArgs() // Clase autogenerada por la librería Navigation que recoge los datos envíados por el otro fragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnimeDetailBinding.inflate(inflater, container, false)
        val view = binding?.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val animeId = args.animeId
        val animeById = mainViewModel.getAnimeById(animeId)

        binding?.animeSynopsis?.text = animeById?.synopsis
        Picasso.get().load(animeById?.posterImage?.original).into(binding?.animeDetailBackground)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}