package com.example.tpandroid1

import android.content.Context
import androidx.room.Room
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton
@Qualifier
annotation class FakeApi
@Qualifier annotation class RealApi
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @RealApi
    @Singleton
    @Provides
    fun provideTmdbApi(): Tmdbapi =
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(Tmdbapi::class.java)

    @FakeApi
    @Singleton
    @Provides
    fun provideFakeTmdbApi(): Tmdbapi = FakeTmdbApi()

    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context,
        converters: Converters
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database-name"
        )
            .addTypeConverter(converters)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideFilmDao(appDatabase: AppDatabase): FilmDao = appDatabase.filmDao()

    @Singleton
    @Provides
    fun provideSerieDao(appDatabase: AppDatabase): SerieDao = appDatabase.serieDao()

    @Singleton
    @Provides
    fun provideActeurDao(appDatabase: AppDatabase): ActeurDao = appDatabase.acteurDao()

    @Singleton
    @Provides
    fun provideRepository(
        @RealApi api: Tmdbapi,
        filmDao: FilmDao,
        serieDao: SerieDao,
        acteurDao: ActeurDao
    ): Repository {
        return Repository(api, filmDao, serieDao, acteurDao)
    }

    @Provides
    @Singleton
    fun provideConverters(): Converters {
        val moshi = Moshi.Builder().build()
        return Converters(moshi)
    }
}
