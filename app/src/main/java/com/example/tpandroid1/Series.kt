package com.example.tpandroid1

import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Series(viewModel: MainViewModel, navController: NavHostController) {
    var searchQuery by remember { mutableStateOf("") }
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
                        onSearch = { viewModel.getMovieByName(searchQuery) },
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
                            IconButton(onClick = { }) {
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
        Text("CC", modifier = Modifier.padding(innerPadding))
    }
}
