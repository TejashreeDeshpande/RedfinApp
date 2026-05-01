package com.example.redfinapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.redfinapp.ui.screens.HomeScreen
import com.example.redfinapp.ui.screens.PropertyDetailScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object PropertyDetail : Screen("property_detail/{propertyId}") {
        fun createRoute(propertyId: String) = "property_detail/$propertyId"
    }
}

@Composable
fun RedfinNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onPropertyClick = { property ->
                    navController.navigate(Screen.PropertyDetail.createRoute(property.id))
                }
            )
        }
        composable(Screen.PropertyDetail.route) { backStackEntry ->
            val propertyId = backStackEntry.arguments?.getString("propertyId") ?: ""
            PropertyDetailScreen(
                propertyId = propertyId,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
