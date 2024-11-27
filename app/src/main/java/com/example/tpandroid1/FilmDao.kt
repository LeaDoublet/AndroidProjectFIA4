package com.example.tpandroid1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

// Film DAO
@Dao
interface FilmDao {
    @Query("SELECT * FROM filmentity")
    suspend fun getAllFilms(): List<FilmEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFilm(film: FilmEntity)

    @Query("DELETE FROM filmentity WHERE id = :id")
    suspend fun deleteFilmById(id: String)
}

// Serie DAO
@Dao
interface SerieDao {
    @Query("SELECT * FROM SerieEntity")
    suspend fun getAllSeries(): List<SerieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSerie(serie: SerieEntity)

    @Query("DELETE FROM SerieEntity WHERE id = :id")
    suspend fun deleteSerieById(id: String)
}

@Dao
interface ActeurDao {
    @Query("SELECT * FROM acteurentity")
    suspend fun getAllActeurs(): List<ActeurEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertActeur(acteur: ActeurEntity)

    @Query("DELETE FROM acteurentity WHERE id = :id")
    suspend fun deleteActeurById(id: String)
}

