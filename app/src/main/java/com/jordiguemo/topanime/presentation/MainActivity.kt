package com.jordiguemo.topanime.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jordiguemo.topanime.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    // Por cada activity/fragment (layout) se crea un Binding, vinculado a su XML y sus ids
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(this.layoutInflater) // inicializar
        setContentView(binding.root) // mostar en pantalla
    }
}