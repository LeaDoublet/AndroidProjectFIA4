package com.example.tpandroid1

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    fun provideRepository(@RealApi api: Tmdbapi): Repository {
        return Repository(api)
    }
}
