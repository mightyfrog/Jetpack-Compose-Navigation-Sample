package org.mightyfrog.android.jetpackcomposenavigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavGraph()
        }
    }
}

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(
                onClick = {
                    val text = "Hello"
                    val number = 123
                    navController.navigate("second/$text/$number")
                }
            )
        }
        composable(
            route = "second/{text}/{number}",
            arguments = listOf(
                navArgument("text") {
                    type = NavType.StringType
                },
                navArgument("number") {
                    type = NavType.IntType
                }
            )
        ) { navBackStackEntry ->
            val args = navBackStackEntry.arguments
            val text = args?.getString("text")
            val number = args?.getInt("number")
            SecondScreen(
                text = text,
                number = number,
                onClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}