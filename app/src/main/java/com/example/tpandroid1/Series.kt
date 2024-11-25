package com.example.tpandroid1

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import coil.compose.rememberAsyncImagePainter


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Series(viewModel: MainViewModel, navController: NavHostController, windowSizeClass: WindowSizeClass) {
    val series by viewModel.series.collectAsState()
    var searchQuery by remember { mutableStateOf("") }

    LaunchedEffect(true) { viewModel.getSeries() }

    when (windowSizeClass.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("Fav'app") },
                        actions = {
                            SearchBar(
                                query = searchQuery,
                                onQueryChange = { newQuery ->
                                    searchQuery = newQuery
                                },
                                onSearch = { viewModel.searchSeriesByName(searchQuery) },
                                placeholder = { Text("Rechercher une série") },
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
                            BottomNavigationItems(navController)
                        }
                    )
                }
            ) { innerPadding ->
                SeriesGridContent(series, navController, innerPadding)
            }
        }

        else -> {
            Row(modifier = Modifier.fillMaxSize()) {
                // Barre latérale verticale
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(80.dp)
                        .background(MaterialTheme.colorScheme.surface),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    VerticalNavigationItems(navController)
                }

                // Contenu principal
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 8.dp, vertical = 16.dp)
                ) {
                    TopAppBar(
                        title = { Text("Fav'app") },
                        actions = {
                            SearchBar(
                                query = searchQuery,
                                onQueryChange = { newQuery ->
                                    searchQuery = newQuery
                                },
                                onSearch = { viewModel.searchSeriesByName(searchQuery) },
                                placeholder = { Text("Rechercher une série") },
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
                    SeriesGridContent(series, navController, PaddingValues(0.dp))
                }
            }
        }
    }
}

@Composable
fun SeriesGridContent(series: List<TmdbSerie>, navController: NavHostController, innerPadding: PaddingValues) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(innerPadding),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(series) { serie ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        Log.v("query", "Navigation vers SerieDetailScreen avec serieId: ${serie.id}")
                        navController.navigate("serieDetail/${serie.id}")
                    }
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
                    Spacer(modifier = Modifier.height(8.dp))
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
