package com.example.tpandroid1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
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

@Composable
fun SerieDetailScreen(serieId: Int, viewModel: MainViewModel, navController: NavHostController) {
    viewModel.getSerieDetailById(serieId)
    val serieDetails = viewModel.serieDetails.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // Permet le défilement vertical
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Bouton de retour
        IconButton(
            onClick = { navController.navigate("series") },
            modifier = Modifier.align(Alignment.Start)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBackIosNew,
                contentDescription = "Previous",
                modifier = Modifier.size(50.dp)
            )
        }

        // Affichage des détails de la série
        if (serieDetails.id != 0) {
            Text(
                text = serieDetails.original_name,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Text(
                text = "Release Date: ${serieDetails.first_air_date}",
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 4.dp)
            )

            Text(
                text = serieDetails.overview,
                fontSize = 14.sp,
                modifier = Modifier.padding(vertical = 4.dp)
            )

            Text(
                text = "Genres: ${serieDetails.genres.joinToString { it.name }}",
                fontSize = 14.sp,
                modifier = Modifier.padding(vertical = 4.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Casting section avec LazyRow
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
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(serieDetails.credits.cast) { actor ->
                    ActorCard(actor = actor)
                }
            }
        } else {
            // Chargement des détails
            Text(
                text = "Chargement des détails de la série...",
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 16.dp)
            )
        }
    }
}