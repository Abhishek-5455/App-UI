package com.example.assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.assignment.ui.theme.AssignmentTheme
import com.example.assignment.ui.theme.Screen
import com.example.assignment.ui.theme.components.explore.ExploreScreen
import com.example.assignment.ui.theme.components.refine.RefineScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssignmentTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.ExploreScreen.route
                    ){
                        composable(
                            route = Screen.ExploreScreen.route
                        ){
                            ExploreScreen(navController = navController)
                        }
                        composable(
                            route = Screen.RefineScreen.route
                        ){
                            RefineScreen(navController = navController)
                        }
                    }

                }
            }
        }
    }
}