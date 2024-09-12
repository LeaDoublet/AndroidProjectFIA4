package com.example.tpandroid1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
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
import com.example.tpandroid1.ui.theme.TPAndroid1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TPAndroid1Theme {
                val navController = rememberNavController()
                NavigationComponent(navController)
            }
        }
    }
}

@Composable
fun NavigationComponent(navController: NavHostController) {
    // NavHost pour définir les destinations et gérer la navigation
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
            Screen(windowSizeClass = windowSizeClass, navController = navController)
        }
        composable("movie") {
            MovieScreen()
        }
    }
}

@Composable
fun Screen(windowSizeClass: WindowSizeClass, navController: NavHostController, modifier: Modifier = Modifier) {
    when (windowSizeClass.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> {
            Column(
                modifier = Modifier.fillMaxSize(),
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
                    modifier = modifier.size(150.dp),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Expert en préparation de burgers\nBikini Bottom, Océan Pacifique",
                    modifier = modifier
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
                            modifier = Modifier.padding(start = 8.dp)
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

@Composable
fun MovieScreen() {
    // Contenu de l'écran MovieActivity
    Text(text = "Bienvenue dans MovieActivity !")
}
