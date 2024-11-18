package com.example.tpandroid1

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") api_key: String ): TmdbMovieResult

    @GET("movie/{movie_id}")
    suspend fun getmoviedetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") api_key: String
    ) : Movie

    @GET("search/person")
    suspend fun getactor(
        @Query("api_key") api_key: String,
        @Query("person") person: String
    ) : TmdbActeurResult

    @GET("search/movie")
    suspend fun getMovieByKeyWord(
        @Query("api_key") api_key: String,
        @Query("query") keyWord: String
    ):TmdbMovieResult

    @GET("trending/tv/week")
    suspend fun lastseries(@Query("api_key") api_key: String ): TmdbSerieResult

    @GET("tv/{tv_id}")
    suspend fun getseriedetail(
        @Path("tv_id") serieId: Int,
        @Query("api_key") api_key: String
    ) : TmdbSerie

    @GET("trending/person/week")
    suspend fun getActeurs(
        @Query("api_key") api_key: String
    ) : TmdbActeurResult

    @GET("search/tv")
    suspend fun getSerieByKeyWord(
        @Query("api_key") api_key: String,
        @Query("query") keyWord: String
    ):TmdbSerieResult

    @GET("search/person")
    suspend fun getActeurByKeyWord(
        @Query("api_key") api_key: String,
        @Query("query") keyWord: String
    ):TmdbActeurResult


}