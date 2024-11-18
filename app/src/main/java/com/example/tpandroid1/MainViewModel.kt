package com.example.tpandroid1

import android.util.Log
import android.widget.ListView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel : ViewModel() {
    //var listFilmTendance by MutableList(6,"")
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val api=retrofit.create(Api::class.java)
    val movies = MutableStateFlow<List<TmdbMovie>>(listOf())
    val series = MutableStateFlow<List<TmdbSerie>>(listOf())
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

    fun getActeurs() {
        viewModelScope.launch {
            val acteurs = api.getActeurs(api_key = api_key).results
            Log.v("query",acteurs.toString())

        }
    }


}