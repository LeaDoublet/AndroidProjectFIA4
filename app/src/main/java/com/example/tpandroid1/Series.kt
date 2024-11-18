package com.example.tpandroid1

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Series(viewModel: MainViewModel, navController: NavHostController) {
    val series by viewModel.series.collectAsState()
    var searchQuery by remember { mutableStateOf("") }

    LaunchedEffect(true) {viewModel.getSeries() }
    //Log.v("querycomposable",series.toString())

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Fav'app") },
                actions = {
                    SearchBar(
                        query = searchQuery,
                        onQueryChange = { newQuery ->
                            searchQuery = newQuery
                            //viewModel.getMovieByName(newQuery)
                        },
                        onSearch = { viewModel.getSerieByName(searchQuery) },
                        placeholder = { Text("Rechercher une serie") },
                        active = false,
                        onActiveChange = { active ->
                            if (!active) {
                                searchQuery = ""
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ){

                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 16.dp),
                content = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            IconButton(onClick = {
                                navController.navigate("movie")
                            }) {
                                Icon(
                                    imageVector = Icons.Filled.Movie,
                                    contentDescription = "Movie Clap Icon",
                                    modifier = Modifier.size(50.dp)
                                )
                            }
                            Text("Films")
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            IconButton(onClick = { navController.navigate("series") }) {
                                Icon(
                                    imageVector = Icons.Filled.Tv,
                                    contentDescription = "Television Icon",
                                    modifier = Modifier.size(50.dp)
                                )
                            }
                            Text("Series")
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            IconButton(onClick = {
                                //Log.v("Navigation", "Navigating to personnes")
                                navController.navigate("personnes") }) {
                                Icon(
                                    imageVector = Icons.Filled.Person,
                                    contentDescription = "Person Icon",
                                    modifier = Modifier.size(50.dp)
                                )
                            }
                            Text("Acteurs")
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyVerticalGrid(

            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(series) { serie ->
                //Log.v("querySerie",serie.original_name)
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        val imageUrl = "https://image.tmdb.org/t/p/w780" + serie.poster_path
                        Image(
                            painter = rememberAsyncImagePainter(imageUrl),
                            contentDescription = serie.original_name,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                        )
                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )
                        Text(
                            text = serie.original_name,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = serie.first_air_date,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                }

            }
    }
}
}
