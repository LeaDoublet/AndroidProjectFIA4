package com.example.tpandroid1
/*
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
//import kotlinx.coroutines.flow.internal.NoOpContinuation.context

@Database(entities = [FilmEntity::class, SerieEntity::class, ActeurEntity::class], version = 4)
abstract class AppDatabase : RoomDatabase() {
    fun filmDao() {
        //TODO

    }
}
/*
val database = Room.databaseBuilder( context, AppDatabase::class.java, "database-name" )
.fallbackToDestructiveMigration()
.build()
val dao = database.filmDao()
// liste des films de la base de données
val favs = db.getFavFilms()
// insérer un nouveau film `film` dans la base
val filmEntity = FilmEntity(id = film.id, titre = film.title)
db.insertFilm(filmEntity)
// supprimer un film
db.deleteFilm(film.id)
}*/