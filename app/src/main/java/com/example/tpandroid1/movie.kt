package com.example.tpandroid1

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(
            onClick = { navController.navigate("movie") },
            modifier = Modifier.align(Alignment.Start)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBackIosNew,
                contentDescription = "Previous",
                modifier = Modifier.size(50.dp)
            )
        }

        if (movieDetails.id != 0) {
            Text(
                text = movieDetails.original_title,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = "Release Date: ${movieDetails.release_date}",
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Text(
                text = movieDetails.overview,
                fontSize = 14.sp,
                modifier = Modifier.padding(vertical = 4.dp)
            )

            val imageUrl = "https://image.tmdb.org/t/p/w780${movieDetails.poster_path}"
            Image(
                painter = rememberAsyncImagePainter(imageUrl),
                contentDescription = movieDetails.original_title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(vertical = 8.dp)
            )

            Text(
                text = "Genres: ${movieDetails.genres.joinToString { it.name }}",
                fontSize = 14.sp,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Text(
                text = "Budget: $${movieDetails.budget}",
                fontSize = 14.sp,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        } else {
            Text(
                text = "Chargement des détails du film...",
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 16.dp)
            )
        }
    }
}