package com.example.tpandroid1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.tpandroid1.ui.theme.TPAndroid1Theme

class MovieActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TPAndroid1Theme {
                MovieScreen()
            }
        }
    }
}
@Composable
fun MovieScreen() {
    // Contenu de l'écran MovieActivity
    Text(text = "Bienvenue dans MovieActivity !")
}