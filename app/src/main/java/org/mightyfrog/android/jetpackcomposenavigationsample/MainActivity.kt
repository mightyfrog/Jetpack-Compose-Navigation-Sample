package org.mightyfrog.android.jetpackcomposenavigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

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