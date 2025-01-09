package com.example.chessmate.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.chessmate.presentation.ui.home.StreamerDetailScreen
import com.example.chessmate.presentation.ui.home.StreamerListScreen

sealed class Screen(val route: String) {
    object StreamerListScreen : Screen("streamer_list_screen")
    object StreamerDetailScreen : Screen("streamer_detail_screen") {
        const val ARG_USERNAME = "username"
        const val ARG_FOLLOWERS = "followers"
        const val ARG_LEAGUE = "league"
        const val ARG_LAST_ONLINE = "last_online"

        fun createRoute(
            username: String,
            followers: Int,
            league: String,
            lastOnline: Int,
        ): String {
            return "streamer_detail_screen?$ARG_USERNAME=$username&$ARG_FOLLOWERS=$followers&$ARG_LEAGUE=$league&$ARG_LAST_ONLINE=$lastOnline"
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.StreamerListScreen.route
    ) {
        composable(route = Screen.StreamerListScreen.route) {
            StreamerListScreen(navController = navController)
        }
        composable(
            route = Screen.StreamerDetailScreen.route + "?${Screen.StreamerDetailScreen.ARG_USERNAME}={${Screen.StreamerDetailScreen.ARG_USERNAME}}&${Screen.StreamerDetailScreen.ARG_FOLLOWERS}={${Screen.StreamerDetailScreen.ARG_FOLLOWERS}}&${Screen.StreamerDetailScreen.ARG_LEAGUE}={${Screen.StreamerDetailScreen.ARG_LEAGUE}}&${Screen.StreamerDetailScreen.ARG_LAST_ONLINE}={${Screen.StreamerDetailScreen.ARG_LAST_ONLINE}}",
            arguments = listOf(
                navArgument(Screen.StreamerDetailScreen.ARG_USERNAME) { type = NavType.StringType },
                navArgument(Screen.StreamerDetailScreen.ARG_FOLLOWERS) { type = NavType.IntType },
                navArgument(Screen.StreamerDetailScreen.ARG_LEAGUE) { type = NavType.StringType },
                navArgument(Screen.StreamerDetailScreen.ARG_LAST_ONLINE) { type = NavType.IntType },
            )
        ) { backStackEntry ->
            val username = backStackEntry.arguments?.getString(Screen.StreamerDetailScreen.ARG_USERNAME) ?: ""
            val followers = backStackEntry.arguments?.getInt(Screen.StreamerDetailScreen.ARG_FOLLOWERS) ?: 0
            val league = backStackEntry.arguments?.getString(Screen.StreamerDetailScreen.ARG_LEAGUE) ?: ""
            val lastOnline = backStackEntry.arguments?.getInt(Screen.StreamerDetailScreen.ARG_LAST_ONLINE) ?: 0
            StreamerDetailScreen(
                username = username,
                followers = followers,
                league = league,
                lastOnline = lastOnline
            )
        }
    }
}