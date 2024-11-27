package com.example.tpandroid1

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class SerieEntity(val fiche: TmdbSerie, @PrimaryKey val id: String,
                       val title: String,
                       val description: String,
                       val releaseDate: String,
                       val isFavorite: Boolean)
