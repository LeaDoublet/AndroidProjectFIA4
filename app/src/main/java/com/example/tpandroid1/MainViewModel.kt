package com.example.tpandroid1

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationtest.playlistjson
import com.squareup.moshi.Moshi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val movies = MutableStateFlow<List<TmdbMovie>>(emptyList())
    val series = MutableStateFlow<List<TmdbSerie>>(emptyList())
    val acteurs = MutableStateFlow<List<TmdbActeur>>(emptyList())
    val movieDetails = mutableStateOf(TmdbMovieDetail())
    val serieDetails = mutableStateOf(TmdbSerieDetail())
    val playlists = MutableStateFlow<List<Playlist>>(emptyList())

    fun getMovies() {
        viewModelScope.launch {
            try {
                movies.value = repository.getLastMovies()
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error fetching movies: ${e.message}")
            }
        }
    }

    fun getSeries() {
        viewModelScope.launch {
            try {
                series.value = repository.getLastSeries()
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error fetching series: ${e.message}")
            }
        }
    }
    fun getPlaylist() {
        viewModelScope.launch {
            try {
                playlists.value = listOf(repository.getPlaylist())
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error fetching series: ${e.message}")
            }
        }
    }


    fun searchMoviesByName(keyword: String) {
        viewModelScope.launch {
            try {
                movies.value = repository.searchMoviesByName(keyword)
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error searching movies: ${e.message}")
            }
        }
    }

    fun searchSeriesByName(keyword: String) {
        viewModelScope.launch {
            try {
                series.value = repository.searchSeriesByName(keyword)
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error searching series: ${e.message}")
            }
        }
    }

    fun getMovieDetailsById(movieId: Int) {
        viewModelScope.launch {
            try {
                movieDetails.value = repository.getMovieDetailsById(movieId)
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error fetching movie details: ${e.message}")
                movieDetails.value = TmdbMovieDetail() // Placeholder en cas d'erreur
            }
        }
    }

    fun getSerieDetailsById(serieId: Int) {
        viewModelScope.launch {
            try {
                serieDetails.value = repository.getSerieDetailsById(serieId)
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error fetching serie details: ${e.message}")
                serieDetails.value = TmdbSerieDetail() // Placeholder en cas d'erreur
            }
        }
    }

    fun getActors() {
        viewModelScope.launch {
            try {
                acteurs.value = repository.getActors()
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error fetching actors: ${e.message}")
            }
        }
    }

    fun searchActorsByName(keyword: String) {
        viewModelScope.launch {
            try {
                acteurs.value = repository.searchActorsByName(keyword)
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error searching actors: ${e.message}")
            }
        }
    }
}
