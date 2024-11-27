package com.example.tpandroid1

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [FilmEntity::class, SerieEntity::class,
    ActeurEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
    abstract fun serieDao(): SerieDao
    abstract fun acteurDao(): ActeurDao
}