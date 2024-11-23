package com.example.tpandroid1
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.vector.ImageVector
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
            val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
            MovieScreen(windowSizeClass = windowSizeClass,viewModel = viewModel,navController = navController)
        }
        composable("series") {
            Series(viewModel = viewModel,navController = navController)
        }
        composable("personnes") {
            Acteurs(viewModel=viewModel, navController = navController)
        }
        composable("movieDetail/{movieId}") { backStackEntry ->
            val movieIdrecup = backStackEntry.arguments?.getString("movieId")?.toInt() ?: 0
            Log.v("query","L'id recup est $movieIdrecup")
            MovieDetailScreen(movieId = movieIdrecup, viewModel = viewModel, navController = navController)
        }
        composable("serieDetail/{serieId}") { backStackEntry ->
            val serieIdrecup = backStackEntry.arguments?.getString("serieId")?.toInt() ?: 0
            Log.v("query", "L'id recup est $serieIdrecup")
            SerieDetailScreen(
                serieId = serieIdrecup,
                viewModel = viewModel,
                navController = navController
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieScreen(
    viewModel: MainViewModel,
    navController: NavHostController,
    windowSizeClass: WindowSizeClass
) {
    val movies by viewModel.movies.collectAsState()
    var searchQuery by remember { mutableStateOf("") }

    LaunchedEffect(true) { viewModel.getMovies() }

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
                                    viewModel.getMovieByName(searchQuery)
                                },
                                placeholder = { Text("Rechercher un film") },
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
                MovieGridContent(movies, navController, innerPadding)
            }
        }

        else -> {
            Row(modifier = Modifier.fillMaxSize()) {
                // Barre latérale verticale pour ergonomie
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
                                onSearch = {
                                    viewModel.getMovieByName(searchQuery)
                                },
                                placeholder = { Text("Rechercher un film") },
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
                    MovieGridContent(movies, navController, PaddingValues(0.dp))
                }
            }
        }
    }
}

@Composable
fun BottomNavigationItems(navController: NavHostController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        NavigationItem(
            icon = Icons.Filled.Movie,
            label = "Films",
            onClick = { navController.navigate("movie") }
        )
        NavigationItem(
            icon = Icons.Filled.Tv,
            label = "Series",
            onClick = { navController.navigate("series") }
        )
        NavigationItem(
            icon = Icons.Filled.Person,
            label = "Acteurs",
            onClick = { navController.navigate("personnes") }
        )
    }
}

@Composable
fun VerticalNavigationItems(navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxHeight()
    ) {
        NavigationItem(
            icon = Icons.Filled.Movie,
            label = "Films",
            onClick = { navController.navigate("movie") }
        )
        NavigationItem(
            icon = Icons.Filled.Tv,
            label = "Series",
            onClick = { navController.navigate("series") }
        )
        NavigationItem(
            icon = Icons.Filled.Person,
            label = "Acteurs",
            onClick = { navController.navigate("personnes") }
        )
    }
}

@Composable
fun NavigationItem(icon: ImageVector, label: String, onClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        IconButton(onClick = onClick) {
            Icon(imageVector = icon, contentDescription = label, modifier = Modifier.size(50.dp))
        }
        Text(label)
    }
}

@Composable
fun MovieGridContent(movies: List<TmdbMovie>, navController: NavHostController, innerPadding: PaddingValues) {
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
                    .clickable {
                        navController.navigate("movieDetail/${movie.id}")
                    }
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
                    Spacer(modifier = Modifier.height(8.dp))
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


