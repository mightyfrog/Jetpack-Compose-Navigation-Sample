package org.mightyfrog.android.jetpackcomposenavigationsample

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(
                onClick = {
                    navController.navigate("second")
                }
            )
        }
        composable("second") {
            SecondScreen(
                onClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}