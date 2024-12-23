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

data class TmdbActeurResult(
    val page: Int = 0,
    val results: List<TmdbActeur> = listOf(),
    val total_pages: Int = 0,
    val total_results: Int = 0
)

data class TmdbActeur(
    val adult: Boolean = false,
    val gender: Int = 0,
    val id: Int = 0,
    val known_for_department: String = "",
    val media_type: String = "",
    val name: String = "",
    val original_name: String = "",
    val popularity: Double = 0.0,
    val profile_path: String = ""
)
data class TmdbSerieResult(
    val page: Int = 0,
    val results: List<TmdbSerie> = listOf(),
    val total_pages: Int = 0,
    val total_results: Int = 0
)
data class PlaylistResult(
    val results: List<Playlist> = listOf()
)

data class TmdbSerie(
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val first_air_date: String = "",
    val genre_ids: List<Int> = listOf(),
    val id: Int = 0,
    val media_type: String = "",
    val name: String = "",
    val origin_country: List<String> = listOf(),
    val original_language: String = "",
    val original_name: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)
data class TmdbMovieDetail(
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val belongs_to_collection: BelongsToCollection = BelongsToCollection(),
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
data class TmdbSerieDetail(
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val created_by: List<CreatedBy> = listOf(),
    val credits: Credits = Credits(),
    val episode_run_time: List<Any> = listOf(),
    val first_air_date: String = "",
    val genres: List<Genre> = listOf(),
    val homepage: String = "",
    val id: Int = 0,
    val in_production: Boolean = false,
    val languages: List<String> = listOf(),
    val last_air_date: String = "",
    val last_episode_to_air: LastEpisodeToAir = LastEpisodeToAir(),
    val name: String = "",
    val networks: List<Network> = listOf(),
    val next_episode_to_air: NextEpisodeToAir = NextEpisodeToAir(),
    val number_of_episodes: Int = 0,
    val number_of_seasons: Int = 0,
    val origin_country: List<String> = listOf(),
    val original_language: String = "",
    val original_name: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    val production_companies: List<ProductionCompany> = listOf(),
    val production_countries: List<ProductionCountry> = listOf(),
    val seasons: List<Season> = listOf(),
    val spoken_languages: List<SpokenLanguage> = listOf(),
    val status: String = "",
    val tagline: String = "",
    val type: String = "",
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)

data class CreatedBy(
    val credit_id: String = "",
    val gender: Int = 0,
    val id: Int = 0,
    val name: String = "",
    val original_name: String = "",
    val profile_path: Any = Any()
)


data class LastEpisodeToAir(
    val air_date: String = "",
    val episode_number: Int = 0,
    val episode_type: String = "",
    val id: Int = 0,
    val name: String = "",
    val overview: String = "",
    val production_code: String = "",
    val runtime: Int = 0,
    val season_number: Int = 0,
    val show_id: Int = 0,
    val still_path: String = "",
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)

data class Network(
    val id: Int = 0,
    val logo_path: String = "",
    val name: String = "",
    val origin_country: String = ""
)

data class NextEpisodeToAir(
    val air_date: String = "",
    val episode_number: Int = 0,
    val episode_type: String = "",
    val id: Int = 0,
    val name: String = "",
    val overview: String = "",
    val production_code: String = "",
    val runtime: Any = Any(),
    val season_number: Int = 0,
    val show_id: Int = 0,
    val still_path: Any = Any(),
    val vote_average: Int = 0,
    val vote_count: Int = 0
)


data class Season(
    val air_date: String = "",
    val episode_count: Int = 0,
    val id: Int = 0,
    val name: String = "",
    val overview: String = "",
    val poster_path: String = "",
    val season_number: Int = 0,
    val vote_average: Double = 0.0
)

data class BelongsToCollection(
    val backdrop_path: String = "",
    val id: Int = 0,
    val name: String = "",
    val poster_path: String = ""
)
data class Playlist(
    val checksum: String,
    val collaborative: Boolean,
    val cover: String,
    val creation_date: String,
    val creator: Creator,
    val description: String,
    val duration: Int,
    val fans: Int,
    val id: Int,
    val is_loved_track: Boolean,
    val link: String,
    val md5_image: String,
    val nb_tracks: Int,
    val picture_type: String,
    val `public`: Boolean,
    val share: String,
    val title: String,
    val tracklist: String,
    val tracks: Tracks,
    val type: String
)

data class Creator(
    val id: Int,
    val name: String,
    val tracklist: String,
    val type: String
)

data class Tracks(
    val checksum: String,
    val `data`: List<Data>
)

data class Data(
    val album: Album,
    val artist: Artist,
    val duration: Int,
    val explicit_content_cover: Int,
    val explicit_content_lyrics: Int,
    val explicit_lyrics: Boolean,
    val id: Long,
    val isrc: String,
    val link: String,
    val md5_image: String,
    val preview: String,
    val rank: Int,
    val readable: Boolean,
    val time_add: Int,
    val title: String,
    val title_short: String,
    val title_version: String,
    val type: String
)

data class Album(
    val cover: String,
    val id: Int,
    val md5_image: String,
    val title: String,
    val tracklist: String,
    val type: String,
    val upc: String
)

data class Artist(
    val id: Int,
    val link: String,
    val name: String,
    val tracklist: String,
    val type: String
)

