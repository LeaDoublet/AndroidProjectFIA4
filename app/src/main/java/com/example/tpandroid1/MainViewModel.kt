package com.example.tpandroid1

import android.widget.ListView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    val api_key = "5589302c27bf6110d7ea1724232a8e7e"
    fun getMovies(){
        viewModelScope.launch {
            movies.value=api.lastmovies(api_key =api_key ).results
        }
    }
   /* val response = api.getactor(query = "Bill Skarsgård",
        api_key = "5589302c27bf6110d7ea1724232a8e7e"
    )*/

}