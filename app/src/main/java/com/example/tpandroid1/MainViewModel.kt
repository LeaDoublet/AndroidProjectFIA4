package com.example.tpandroid1

import android.util.Log
import android.widget.ListView
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.Flow

class MainViewModel : ViewModel() {
    //var listFilmTendance by MutableList(6,"")
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val api=retrofit.create(Api::class.java)
    val movies = MutableStateFlow<List<TmdbMovie>>(listOf())
    val series = MutableStateFlow<List<TmdbSerie>>(listOf())
    val acteurs = MutableStateFlow<List<TmdbActeur>>(listOf())
    val movieDetails = mutableStateOf(TmdbMovieDetail())
    val api_key = "5589302c27bf6110d7ea1724232a8e7e"
    fun getMovies(){
        viewModelScope.launch {
            movies.value=api.lastmovies(api_key =api_key ).results
        }
    }

    fun getSeries(){
        viewModelScope.launch {
            series.value=api.lastseries(api_key =api_key ).results
            Log.v("queryviewmodel",series.value.toString())
        }
    }

    fun getSerieByName(keyWord:String){
        viewModelScope.launch {
            try {
                val searchResults = api.getSerieByKeyWord(api_key = api_key, keyWord = keyWord)
                // Mettre à jour la liste des serie avec les résultats de la recherche
                series.value = searchResults.results
            } catch (e: Exception) {
                Log.v("query","Erreur lors de la recherche de serie: ${e.message}")
            }
        }
    }

    fun getMovieByName(keyWord:String){
        viewModelScope.launch {
            try {
                val searchResults = api.getMovieByKeyWord(api_key = api_key, keyWord = keyWord)
                // Mettre à jour la liste des films avec les résultats de la recherche
                movies.value = searchResults.results
                Log.v("query",movies.value.toString())
            } catch (e: Exception) {
                Log.v("query","Erreur lors de la recherche de films: ${e.message}")
            }
        }
    }
    fun getMovieDetailById(movieId: Int) {
        viewModelScope.launch {
            try {
                val movieDetailsResponse = api.getMovieDetailById(api_key = api_key, movieId = movieId)
                Log.v("queryVMDetail",movieDetailsResponse.toString())
                movieDetails.value = movieDetailsResponse
            } catch (e: Exception) {
                Log.v("query", "Erreur lors de la recherche de films: ${e.message}")
                // Émettre un objet vide en cas d'erreur
                movieDetails.value = TmdbMovieDetail()
            }
        }
    }

    fun getActeurs() {
        viewModelScope.launch {
            acteurs.value = api.getActeurs(api_key = api_key).results
            Log.v("query",acteurs.toString())

        }
    }

    fun getActeurByName(keyWord: String) {
        viewModelScope.launch {
            try {
                val searchResults = api.getActeurByKeyWord(api_key = api_key, keyWord = keyWord)
                // Mettre à jour la liste des acteurs avec les résultats de la recherche
                acteurs.value = searchResults.results
            } catch (e: Exception) {
                Log.v("query", "Erreur lors de la recherche d'acteur: ${e.message}")

            }
        }

    }
}