package com.example.tpandroid1

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Music(viewModel: MainViewModel, navController: NavHostController, windowSizeClass: WindowSizeClass) {
    var searchQuery by remember { mutableStateOf("") }
    val Playlist by viewModel.playlists.collectAsState()

    LaunchedEffect(true) { viewModel.getPlaylist() }

    Log.v("music",Playlist.toString())
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
                                onSearch = {
                                    onSearch(searchQuery,viewModel,"music")
                                },
                                placeholder = { Text("Rechercher un musicien") },
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
            ) {innerPadding ->
                MusicGridContent(Playlist,navController,innerPadding)
            }
        }
    }
}
@Composable
fun MusicGridContent(playlists: List<Playlist>, navController: NavHostController, innerPadding: PaddingValues) {
    var cellule: Int = 2;
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
    when (windowSizeClass.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> {
            cellule = 2
        }
        WindowWidthSizeClass.MEDIUM -> {
            cellule = 3
        }

    }
    LazyVerticalGrid(
        columns = GridCells.Fixed(cellule),
        modifier = Modifier.padding(innerPadding),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        items(playlists) { playl ->
            Log.v("querySerie", playl.title)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = playl.title,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}