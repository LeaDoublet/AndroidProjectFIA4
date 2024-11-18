package com.example.tpandroid1

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.compose.rememberAsyncImagePainter
@Composable
fun MovieDetailScreen(movieId: Int, viewModel: MainViewModel, navController: NavHostController) {
    Log.v("query","L'id est $movieId, je suis dans le detail du film")
    viewModel.getMovieDetailById(movieId)
    val movieDetails = viewModel.movieDetails.value

    Column(modifier = Modifier.padding(16.dp)) {
        IconButton(
            onClick = { navController.navigate("movie") },
            modifier = Modifier.align(Alignment.Start)
        ) { Icon(
            imageVector = Icons.Filled.ArrowBackIosNew,
            contentDescription = "Previous",
            modifier = Modifier.size(50.dp)
        )
        }
        Text(text = movieDetails.overview, fontWeight = FontWeight.Bold, fontSize = 24.sp)
        Text(text = "Release Date: ${movieDetails.release_date}")
        Text(text = movieDetails.overview)


        val imageUrl = "https://image.tmdb.org/t/p/w780${movieDetails.poster_path}"
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = movieDetails.original_title,
            modifier = Modifier.fillMaxWidth().height(180.dp)
        )

        Text(text = "Genres: ${movieDetails.genres.joinToString { it.name }}")
        Text(text = "Budget: $${movieDetails.budget}")
    }
}