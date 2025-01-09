package com.example.chessmate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chessmate.presentation.navigation.AppNavigation
import com.example.chessmate.presentation.ui.home.StreamerListScreen
import com.example.chessmate.presentation.ui.theme.ChessMateAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChessMateAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.StreamerListScreen.route
                    ) {
                        composable(
                            route = Screen.StreamerListScreen.route
                        ) {
                            StreamerListScreen(navController)
                        }
                    }
                    AppNavigation()
                }
            }
        }
    }
}