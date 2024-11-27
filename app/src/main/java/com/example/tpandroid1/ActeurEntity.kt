package com.example.tpandroid1

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class ActeurEntity(val fiche: TmdbActeur, @PrimaryKey val id: String,val title: String,val isFavorite: Boolean)
