package com.example.tpandroid1

import com.example.myapplicationtest.playlistjson
import com.squareup.moshi.Moshi
import javax.inject.Inject

class Repository @Inject constructor(
    private val tmdbapi: Tmdbapi,
   // private val db: FilmDao // Optionnel si une base de données est utilisée
) {
    private val api_key = "5589302c27bf6110d7ea1724232a8e7e"
    val moshi = Moshi.Builder().build()
    suspend fun getLastMovies() = tmdbapi.lastmovies(api_key = api_key).results
    suspend fun getLastSeries() = tmdbapi.lastseries(api_key = api_key).results
    suspend fun searchMoviesByName(keyword: String) = tmdbapi.getMovieByKeyWord(api_key = api_key, keyWord = keyword).results
    suspend fun searchSeriesByName(keyword: String) = tmdbapi.getSerieByKeyWord(api_key = api_key, keyWord = keyword).results
    suspend fun getMovieDetailsById(movieId: Int) = tmdbapi.getMovieDetailById(api_key = api_key, movieId = movieId)
    suspend fun getSerieDetailsById(serieId: Int) = tmdbapi.getSerieDetailById(api_key = api_key, serieId = serieId)
    suspend fun getActors() = tmdbapi.getActeurs(api_key = api_key).results
    suspend fun searchActorsByName(keyword: String) = tmdbapi.getActeurByKeyWord(api_key = api_key, keyWord = keyword).results

    fun getPlaylist()= ( moshi.adapter(Playlist::class.java).fromJson(playlistjson)!!)


}
