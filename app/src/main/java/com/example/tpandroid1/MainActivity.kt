package com.example.tpandroid1

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import coil.compose.AsyncImage
import com.example.tpandroid1.ui.theme.TPAndroid1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
                Screen(windowSizeClass)
            }
    }

}

@Composable
fun Screen(windowClass: WindowSizeClass,modifier: Modifier=Modifier) {
    when (windowClass.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                // prend tout l'espace de l'écran
                horizontalAlignment = Alignment.CenterHorizontally,  // Centre les éléments horizontalement
                verticalArrangement = Arrangement.Center
            ) {

                Image(
                    painterResource(R.drawable.bob),
                    contentDescription = "bob leponge",
                    contentScale = ContentScale.Crop,            // crop the image if it's not a square
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape)                       // clip to the circle shape
                )
                Text(
                    text = "Bob l\'eponge",
                    modifier = modifier
                        .size(150.dp),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Expert en préparation de burgers\n" +
                            "Bikini Bottom, Océan Pacifique",
                    modifier = modifier
                )
                Row(
                    modifier = Modifier,
                ) {
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
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.linkin),
                        contentDescription = "Icon mail",
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        text = "www.linkedin.com/\nbob-leponge-bikinibottom/",
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
                Button(
                    onClick = {
                        // Action à exécuter lors du clic
                    },
                    modifier = Modifier.padding(16.dp) // Modifier pour ajuster les marges ou autres styles
                ) {
                    Text(text = "demarrer")  // Contenu du bouton
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
                // Première colonne avec l'image et les informations principales
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
                // Deuxième colonne avec les icônes et le bouton
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
                        onClick = { /* Action à exécuter */ },
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Text(text = "Démarrer")
                    }
                }
            }
        }
    }
}

