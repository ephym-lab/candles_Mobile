package com.example.candles.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String? = null, val icon: ImageVector? = null) {
    object Splash : Screen("splash")
    object Home : Screen("home", "Home", Icons.Default.Home)
    object Shop : Screen("shop", "Shop", Icons.Default.Search)
    object Cart : Screen("cart", "Cart", Icons.Default.ShoppingCart)
    object Profile : Screen("profile", "Profile", Icons.Default.Person)
    object ProductDetail : Screen("product_detail/{productId}") {
        fun createRoute(productId: Int) = "product_detail/$productId"
    }
}

val bottomNavItems = listOf(
    Screen.Home,
    Screen.Shop,
    Screen.Cart,
    Screen.Profile
)
