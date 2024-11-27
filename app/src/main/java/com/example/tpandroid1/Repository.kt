package com.example.tpandroid1

import javax.inject.Inject

class Repository @Inject constructor(
    private val tmdbapi: Tmdbapi,
    private val filmDao: FilmDao,
    private val serieDao: SerieDao,
    private val acteurDao: ActeurDao
) {
    private val api_key = "5589302c27bf6110d7ea1724232a8e7e"

    suspend fun getLastMovies(): List<TmdbMovie> {
        val favoriteFilmIds: Set<String> = filmDao.getAllFilms().map { it.id }.toSet()
        return tmdbapi.lastmovies(api_key).results.map { movie ->
            if (favoriteFilmIds.contains(movie.id as String)) movie.copy(isFav = true)
            else movie
        }
    }
    suspend fun getMovieDetailsById(movieId: Int) = tmdbapi.getMovieDetailById(api_key = api_key, movieId = movieId.toString())
    suspend fun getSerieDetailsById(serieId: Int) = tmdbapi.getSerieDetailById(api_key = api_key, serieId = serieId.toString())

    suspend fun getLastSeries(): List<TmdbSerie> {
        val favoriteSeriesIds: Set<Int> = serieDao.getAllSeries().map { it.id.toInt() }.toSet()

        return tmdbapi.lastseries(api_key).results.map { serie ->
            if (favoriteSeriesIds.contains(serie.id)) serie.copy(isFav = true)
            else serie
        }
    }


    suspend fun getActors(): List<TmdbActeur> {
        val favoriteActorIds: Set<Int> = acteurDao.getAllActeurs().map { it.id.toInt() }.toSet()

        return tmdbapi.getActeurs(api_key).results.map { actor ->
            if (favoriteActorIds.contains(actor.id)) actor.copy(isFav = true)
            else actor
        }
    }


    suspend fun searchMoviesByName(keyword: String): List<TmdbMovie> {
        val favoriteFilms: Set<String> = filmDao.getAllFilms().map { it.id }.toSet()

        return tmdbapi.getMovieByKeyWord(api_key, keyword).results.map { movie ->
            if (favoriteFilms.contains(movie.id)) movie.copy(isFav = true)
            else movie
        }
    }


    suspend fun searchSeriesByName(keyword: String): List<TmdbSerie> {
        val favoriteSeries: Set<Int> = serieDao.getAllSeries().map { it.id.toInt() }.toSet()

        return tmdbapi.getSerieByKeyWord(api_key, keyword).results.map { serie ->
            if (favoriteSeries.contains(serie.id)) serie.copy(isFav = true)
            else serie
        }
    }


    suspend fun searchActorsByName(keyword: String): List<TmdbActeur> {
        val favoriteActors: Set<Int> = acteurDao.getAllActeurs().map { it.id.toInt() }.toSet()

        return tmdbapi.getActeurByKeyWord(api_key, keyword).results.map { actor ->
            if (favoriteActors.contains(actor.id)) actor.copy(isFav = true)
            else actor
        }
    }


    // DAO methods
    suspend fun getAllFilms() = filmDao.getAllFilms()
    suspend fun insertFilm(film: FilmEntity) = filmDao.insertFilm(film)
    suspend fun deleteFilmById(id: String) = filmDao.deleteFilmById(id)

    suspend fun getAllSeries() = serieDao.getAllSeries()
    suspend fun insertSerie(serie: SerieEntity) = serieDao.insertSerie(serie)
    suspend fun deleteSerieById(id: String) = serieDao.deleteSerieById(id)

    suspend fun getAllActeurs() = acteurDao.getAllActeurs()
    suspend fun insertActeur(acteur: ActeurEntity) = acteurDao.insertActeur(acteur)
    suspend fun deleteActeurById(id: String) = acteurDao.deleteActeurById(id)
}
