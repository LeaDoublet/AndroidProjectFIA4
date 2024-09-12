package com.example.tpandroid1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
