package com.example.tpandroid1

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Card
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
import coil.compose.rememberAsyncImagePainter
@Composable
fun ActorCard(actor: Cast) {
    Card(
        modifier = Modifier
            .width(120.dp)
            .padding(4.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            val actorImageUrl = "https://image.tmdb.org/t/p/w185${actor.profile_path}"
            Image(
                painter = rememberAsyncImagePainter(actorImageUrl),
                contentDescription = actor.name,
                modifier = Modifier
                    .size(80.dp)
                    .padding(4.dp)
            )
            Text(
                text = actor.name,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                modifier = Modifier.padding(vertical = 1.dp)
            )
            Text(
                text = "as ${actor.character}",
                fontSize = 10.sp,
                modifier = Modifier.padding(vertical = 1.dp)
            )
        }
    }
}
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
            Text(
                text = "Casting:",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(8.dp)
            ) {
                items(movieDetails.credits.cast) { actor ->
                    ActorCard(actor = actor)
                }
            }
        } else {
            Text(
                text = "Chargement des détails du film...",
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 16.dp)
            )
        }
    }
}