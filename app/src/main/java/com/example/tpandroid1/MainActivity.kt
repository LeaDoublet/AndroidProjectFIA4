package com.example.tpandroid1
import com.example.tpandroid1.Series
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import coil.compose.rememberAsyncImagePainter
import com.example.tpandroid1.ui.theme.TPAndroid1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainViewModel by viewModels()
        enableEdgeToEdge()
        setContent {
            TPAndroid1Theme {
                val navController = rememberNavController()
                NavigationComponent(navController,viewModel)
            }
        }
    }
}

@Composable
fun NavigationComponent(navController: NavHostController, viewModel: MainViewModel) {
    // NavHost pour définir les destinations et gérer la navigation
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
            Profil(windowSizeClass = windowSizeClass, navController = navController)
        }
        composable("movie") {
            MovieScreen(viewModel = viewModel,navController = navController)
        }
        composable("series") {
            Series(viewModel = viewModel,navController = navController)
        }
        composable("acteurs") {
            Acteurs(viewModel=viewModel, navController = navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieScreen(viewModel: MainViewModel,navController: NavHostController) {
    val movies by viewModel.movies.collectAsState()
    var searchQuery by remember { mutableStateOf("") }

    //recherche initale au démarrage de l'appli
    LaunchedEffect(true) { viewModel.getMovies()}

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Fav'app") },
                actions = {
                    SearchBar(
                        query = searchQuery,
                        onQueryChange = { newQuery ->
                            searchQuery = newQuery
                           // viewModel.getMovieByName(newQuery)
                        },
                        onSearch = { viewModel.getMovieByName(searchQuery)
                            Log.v("query",searchQuery)
                                   },
                        placeholder = { Text("Rechercher un film") },
                        active = false,
                        onActiveChange = { active ->
                            if (!active) {
                                searchQuery = ""
                              //  viewModel.getMovies()
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
                modifier = Modifier.fillMaxWidth(),  // Remplir la largeur de l'écran
                contentPadding = PaddingValues(horizontal = 16.dp),  // Optionnel, pour ajouter du padding
                content = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,  // Répartir également les icônes
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
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
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            IconButton(onClick = { navController.navigate("series") }) {
                                Icon(
                                    imageVector = Icons.Filled.Tv,
                                    contentDescription = "Television Icon",
                                    modifier = Modifier.size(50.dp)
                                )

                            }
                            Text("Series")
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            IconButton(onClick = { navController.navigate("acteurs")}) {
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
            items(movies) { movie ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        val imageUrl = "https://image.tmdb.org/t/p/w780" + movie.poster_path
                        Image(
                            painter = rememberAsyncImagePainter(imageUrl),
                            contentDescription = movie.original_title,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                        )
                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )
                        Text(
                            text = movie.original_title,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = movie.release_date,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                }

            }
        }
    }
}



@Composable
fun Profil(windowSizeClass: WindowSizeClass, navController: NavHostController, modifier: Modifier = Modifier) {
    when (windowSizeClass.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> {
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.bob),
                    contentDescription = "bob leponge",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = "Bob l\'éponge",
                    modifier = modifier
                        .padding(50.dp),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Expert en préparation de burgers\nBikini Bottom, Océan Pacifique",
                    modifier = Modifier.padding(50.dp)
                )

                Row(modifier = Modifier) {
                    Icon(
                        painter = painterResource(R.drawable.mail),
                        contentDescription = "Icon mail",
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        text = "bob@gmail.com",
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
                Row(modifier = Modifier, horizontalArrangement = Arrangement.Center) {
                    Icon(
                        painter = painterResource(R.drawable.linkin),
                        contentDescription = "Icon LinkedIn",
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        text = "www.linkedin.com/\nbob-leponge-bikinibottom/",
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
                Button(
                    onClick = {
                        // Navigation vers MovieScreen
                        navController.navigate("movie")
                    },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = "Démarrer")
                }
            }
        }

        else -> {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.weight(1f)
                ) {
                    Image(
                        painter = painterResource(R.drawable.bob),
                        contentDescription = "Bob l'éponge",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(200.dp)
                            .clip(CircleShape)
                    )
                    Text(
                        text = "Bob l'éponge",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(
                        text = "Expert en préparation de burgers\nBikini Bottom, Océan Pacifique",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.weight(1f)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.mail),
                            contentDescription = "Icone mail",
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "bob@gmail.com",
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.linkin),
                            contentDescription = "Icone LinkedIn",
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "www.linkedin.com/bob-leponge",
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }
                    Button(
                        onClick = {
                            // Navigation vers MovieScreen
                            navController.navigate("movie")
                        },
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Text(text = "Démarrer")
                    }
                }
            }
        }
    }
}


