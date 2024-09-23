package com.example.tpandroid1
data class Movie(
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val belongs_to_collection: Any = Any(),
    val budget: Int = 0,
    val credits: Credits = Credits(),
    val genres: List<Genre> = listOf(),
    val homepage: String = "",
    val id: Int = 0,
    val imdb_id: String = "",
    val origin_country: List<String> = listOf(),
    val original_language: String = "",
    val original_title: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    val production_companies: List<ProductionCompany> = listOf(),
    val production_countries: List<ProductionCountry> = listOf(),
    val release_date: String = "",
    val revenue: Int = 0,
    val runtime: Int = 0,
    val spoken_languages: List<SpokenLanguage> = listOf(),
    val status: String = "",
    val tagline: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)

data class Credits(
    val cast: List<Cast> = listOf(),
    val crew: List<Crew> = listOf()
)

data class Genre(
    val id: Int = 0,
    val name: String = ""
)

data class ProductionCompany(
    val id: Int = 0,
    val logo_path: String = "",
    val name: String = "",
    val origin_country: String = ""
)

data class ProductionCountry(
    val iso_3166_1: String = "",
    val name: String = ""
)

data class SpokenLanguage(
    val english_name: String = "",
    val iso_639_1: String = "",
    val name: String = ""
)

data class Cast(
    val adult: Boolean = false,
    val cast_id: Int = 0,
    val character: String = "",
    val credit_id: String = "",
    val gender: Int = 0,
    val id: Int = 0,
    val known_for_department: String = "",
    val name: String = "",
    val order: Int = 0,
    val original_name: String = "",
    val popularity: Double = 0.0,
    val profile_path: String = "",
    var known_for: List<Movie> = listOf()
)

data class Crew(
    val adult: Boolean = false,
    val credit_id: String = "",
    val department: String = "",
    val gender: Int = 0,
    val id: Int = 0,
    val job: String = "",
    val known_for_department: String = "",
    val name: String = "",
    val original_name: String = "",
    val popularity: Double = 0.0,
    val profile_path: String = ""
)


class TmdbMovieResult(
    var page: Int = 0,
    val results: List<TmdbMovie> = listOf()
)
class TmdbMovie(
    var overview: String = "",
    val release_date: String = "",
    val id: String = "",
    val title: String = "",
    val original_title: String = "",
    val backdrop_path: String? = "",
    val genre_ids: List<Int> = listOf(),
    val poster_path: String? = ""
)
class TmdbPersonne(
    var adult: Boolean = false,
    var also_known_as: List<String> = listOf(),
    var biography: String,
    var birthday: String,
    var deathday: String,
    var gender: Int,
    var id: Int,
    var homepage           : String?           = null,
    var imdbId             : String?           = null,
    var knownForDepartment : String?           = null,
    var name               : String?           = null,
    var placeOfBirth       : String?           = null,
    var popularity         : Double?           = null,
    var profilePath        : String

)