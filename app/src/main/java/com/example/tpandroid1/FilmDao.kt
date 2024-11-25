package com.example.tpandroid1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FilmDao {
    /*@Query("SELECT * FROM TmdbMovie")
    suspend fun getFavFilms(): List<TmdbMovie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFilm(film: TmdbMovie)

    @Query("DELETE FROM TmdbMovie WHERE id = :id")
    suspend fun deleteFilm(id: String)*/

}
