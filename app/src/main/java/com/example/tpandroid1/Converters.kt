package com.example.tpandroid1;

import androidx.room.ProvidedTypeConverter;
import androidx.room.TypeConverter;

import com.squareup.moshi.Moshi;

@ProvidedTypeConverter
class Converters(moshi: Moshi) {
    val filmJsonadapter = moshi.adapter(TmdbMovie::class.java)
    val serieJsonadapter = moshi.adapter(TmdbSerie::class.java)
    val acteurJsonadapter = moshi.adapter(TmdbActeur::class.java)

    @TypeConverter
    fun StringToTmdbMovie(value: String): TmdbMovie? {
        return filmJsonadapter.fromJson(value)
    }

    @TypeConverter
    fun TmdbMovieToString(film: TmdbMovie): String {
        return filmJsonadapter.toJson(film)
    }
    @TypeConverter
    fun StringToTmdbSerie(value: String): TmdbSerie? {
        return serieJsonadapter.fromJson(value)
    }
    @TypeConverter
    fun TmdbSerieToString(serie: TmdbSerie): String {
        return serieJsonadapter.toJson(serie)
    }

    @TypeConverter
    fun StringToTmdbActeur(value: String): TmdbActeur? {
        return acteurJsonadapter.fromJson(value)
    }
    @TypeConverter
    fun TmdbActeurToString(acteur: TmdbActeur): String {
        return acteurJsonadapter.toJson(acteur)
    }

}
