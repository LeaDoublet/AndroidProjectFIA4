package com.example.tpandroid1;

//import static kotlin.text.ScreenFloatValueRegEx.value;

import androidx.room.ProvidedTypeConverter;
import androidx.room.Room;
import androidx.room.TypeConverter;

import com.squareup.moshi.Moshi;
/*
@ProvidedTypeConverter
public class Converters {

    private Moshi moshi;
    val filmJsonadapter = moshi.adapter(TmdbMovie::class.java)

    @TypeConverter
    fun StringToTmdbMovie(value: String): TmdbMovie? {
        return filmJsonadapter.fromJson(value);
    }

    @TypeConverter
    fun TmdbMovieToString(film: TmdbMovie): String {
        return filmJsonadapter.toJson(film);
    }
    Room.databaseBuilder( context, AppDatabase::class.java, "database-name" )
            .addTypeConverter(Converters(Moshi.Builder().build()))
            .build().filmDao();
}*/
