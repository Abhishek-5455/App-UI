package com.example.assignment.ui.theme

sealed class Screen(val route: String) {
    object ExploreScreen: Screen("explore_screen")
    object RefineScreen: Screen("refine_screen")
}
