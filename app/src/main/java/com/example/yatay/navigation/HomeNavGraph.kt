package com.example.yatay.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.yatay.ui.YatayAppState
import com.example.yatay.ui.screens.ScreenGallery
import com.example.yatay.ui.screens.ScreenHome
import com.example.yatay.ui.screens.ScreenMap
import com.example.yatay.ui.screens.ScreenMessages
import com.example.yatay.ui.screens.ScreenReserve

@Composable
fun HomeNavGraph(
    appState: YatayAppState,
    modifier: Modifier=Modifier,
    startDestination: String = BottomBarScreen.Pantalla1.route,
   // googleAuthUiClient: GoogleAuthUiClient,
   // lifecycleScope: LifecycleCoroutineScope,
   // applicationContext: Context,
    navController: NavHostController,
) {

    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = startDestination,
        modifier = modifier,
    ) {

        composable(route = BottomBarScreen.Pantalla1.route) {
            ScreenHome()
        }
        composable(route = BottomBarScreen.Pantalla2.route) {
            ScreenMap()
        }
        composable(route = BottomBarScreen.Pantalla3.route) {
            ScreenReserve()
        }
        composable(route = BottomBarScreen.Pantalla4.route) {
            ScreenGallery()
        }
        composable(route = BottomBarScreen.Pantalla5.route) {
            ScreenMessages()
        }
    }
}