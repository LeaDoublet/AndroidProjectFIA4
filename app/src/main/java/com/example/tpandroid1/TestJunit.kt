package com.example.tpandroid1

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test


class TestJunit {

    private val fakeTmdbApi = FakeTmdbApi()

    @Test
    fun testLastMovies() = runBlocking {
        // Simulation de  la déconnexion (pas de requête HTTP )
        val apiKey = "fake-api-key"

        val movieResult = fakeTmdbApi.lastmovies(apiKey)

        assertNotNull(movieResult)

        assert(movieResult.results.isNotEmpty())

        // Vérification qu'un film ( exemple, "Wicked") est bien présent
        val movie = movieResult.results[0]
        assertEquals("Wicked", movie.title)
        assertEquals("Wicked", movie.original_title)
    }
}
