package com.jordiguemo.topanime.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jordiguemo.topanime.R
import com.jordiguemo.topanime.domain.Anime
import com.squareup.picasso.Picasso

class AnimeAdapter(
    val onAnimeClicked: (String) -> Unit // Función que tiene como parámetro una String y devuelve Unit
): RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {
    var animes = listOf<Anime>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)
        return AnimeViewHolder(view)
    }

    override fun onBindViewHolder(animeHolder: AnimeViewHolder, position: Int) {
        val anime = animes[position]
        animeHolder.title.text = anime.titles?.en
        animeHolder.rating.text = anime.averageRating
        Picasso.get().load(anime.posterImage?.original).into(animeHolder.posterImage)
        animeHolder.itemView.setOnClickListener {
            onAnimeClicked(anime.id)
        }
    }

    override fun getItemCount() = animes.size

    class AnimeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.animeTitle)
        val rating: TextView = view.findViewById(R.id.animeRating)
        val posterImage: ImageView = view.findViewById(R.id.animePosterImage)
    }
}