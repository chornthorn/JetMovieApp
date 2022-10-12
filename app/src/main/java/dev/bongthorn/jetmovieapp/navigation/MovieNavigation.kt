package dev.bongthorn.jetmovieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dev.bongthorn.jetmovieapp.screens.HomeScreen
import dev.bongthorn.jetmovieapp.screens.MainScreen
import dev.bongthorn.jetmovieapp.screens.MovieDetailScreen


@Composable
fun MovieNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MovieScreens.MainScreen.name) {
        composable(MovieScreens.MainScreen.name) {
            MainScreen(navController = navController)
        }

        composable(MovieScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }

        composable(
            MovieScreens.MovieDetail.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie") { type = NavType.StringType })
        ) { backStackEntity ->
            MovieDetailScreen(
                navController = navController,
                movie = backStackEntity.arguments?.getString("movie")
            )
        }
    }
}