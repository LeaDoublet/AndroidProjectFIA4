package com.example.tpandroid1

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Music(viewModel: MainViewModel, navController: NavHostController, windowSizeClass: WindowSizeClass) {
    var searchQuery by remember { mutableStateOf("") }
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
                Text(text="je suis dans music")
            }
        }
}   }