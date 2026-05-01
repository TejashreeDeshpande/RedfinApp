package com.example.redfinapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.redfinapp.ui.navigation.RedfinNavGraph
import com.example.redfinapp.ui.theme.RedfinAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RedfinAppTheme {
                val navController = rememberNavController()
                RedfinNavGraph(navController = navController)
            }
        }
    }
}
