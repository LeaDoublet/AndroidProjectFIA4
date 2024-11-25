package com.example.tpandroid1

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import retrofit2.http.Query

public class FakeTmdbApi : Tmdbapi {
    val moshi: Moshi = Moshi.Builder().build()
    val jsonAdapter: JsonAdapter<TmdbMovieResult> = moshi.adapter(TmdbMovieResult::class.java)

    // Faux Json
    val jsonresult = "{\"page\":1,\"results\":[{\"adult\":false, ... "

    override
    suspend fun lastmovies(@Query("api_key") api_key: String): TmdbMovieResult {
        val res = jsonAdapter.fromJson(jsonresult)
        if (res != null) return res
        else return TmdbMovieResult()
    }

    override suspend fun getmoviedetail(movieId: Int, api_key: String): Movie {
        TODO("Not yet implemented")
    }

    override suspend fun getactor(api_key: String, person: String): TmdbActeurResult {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieByKeyWord(api_key: String, keyWord: String): TmdbMovieResult {
        TODO("Not yet implemented")
    }

    override suspend fun lastseries(api_key: String): TmdbSerieResult {
        TODO("Not yet implemented")
    }

    override suspend fun getseriedetail(serieId: Int, api_key: String): TmdbSerie {
        TODO("Not yet implemented")
    }

    override suspend fun getActeurs(api_key: String): TmdbActeurResult {
        TODO("Not yet implemented")
    }

    override suspend fun getSerieByKeyWord(api_key: String, keyWord: String): TmdbSerieResult {
        TODO("Not yet implemented")
    }

    override suspend fun getActeurByKeyWord(api_key: String, keyWord: String): TmdbActeurResult {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieDetailById(
        movieId: Int,
        api_key: String,
        append: String
    ): TmdbMovieDetail {
        TODO("Not yet implemented")
    }

    override suspend fun getSerieDetailById(
        serieId: Int,
        api_key: String,
        append: String
    ): TmdbSerieDetail {
        TODO("Not yet implemented")
    }
}