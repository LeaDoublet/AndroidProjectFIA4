package com.example.tpandroid1

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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
fun Acteurs(viewModel: MainViewModel, navController: NavHostController, windowSizeClass: WindowSizeClass) {
    val acteurs by viewModel.acteurs.collectAsState()
    var searchQuery by remember { mutableStateOf("") }
    LaunchedEffect(true) { viewModel.getActors() }
    Log.v("query", acteurs.toString())

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
                                onSearch = { viewModel.searchActorsByName(searchQuery) },
                                placeholder = { Text("Rechercher un acteur") },
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
                ActeursGridContent(acteurs, navController, innerPadding)
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
                                onSearch = { viewModel.searchActorsByName(searchQuery) },
                                placeholder = { Text("Rechercher un acteur") },
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
                    ActeursGridContent(acteurs, navController, PaddingValues(0.dp))
                }
            }
        }
    }
}

@Composable
fun ActeursGridContent(acteurs: List<TmdbActeur>, navController: NavHostController, innerPadding: PaddingValues) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(innerPadding),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(acteurs) { acteur ->
            Log.v("querySerie", acteur.original_name)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(8.dp)
                ) {
                    val imageUrl = "https://image.tmdb.org/t/p/w780" + acteur.profile_path
                    Image(
                        painter = rememberAsyncImagePainter(imageUrl),
                        contentDescription = acteur.original_name,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = acteur.original_name,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
