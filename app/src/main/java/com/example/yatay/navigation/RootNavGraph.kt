package com.example.yatay.navigation

import android.content.Context
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.yatay.presentation.profile.MiniProfile
import com.example.yatay.presentation.sign_in.GoogleAuthUiClient
import com.example.yatay.ui.YatayApp
import com.example.yatay.ui.rememberYatayAppState

object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
    const val DETAILS = "details_graph"
    const val MINI_PROFILE = "mini_profile"
}
@Composable
fun RootNavigationGraph(
    navController: NavHostController,
    googleAuthUiClient: GoogleAuthUiClient,
    lifeCycleScope: LifecycleCoroutineScope,
    applicationContext: Context,
    windowSize: WindowSizeClass,
    ) {

    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {


        authNavGraph(
            navController = navController,
            applicationContext = applicationContext,
            lifecycleScope = lifeCycleScope,
            googleAuthUiClient = googleAuthUiClient
            )

        composable(route = Graph.HOME) {
            YatayApp(appState = rememberYatayAppState( windowSizeClass = windowSize ))
        }
     /**   composable(route=Graph.MINI_PROFILE){
            MiniProfile(
                googleAuthUiClient.getSignedInUser(),
                onClick = {
                   // navController.popBackStack()
                  //  navController.navigate(Graph.MINI_PROFILE)
                    navController.navigate(Graph.AUTHENTICATION)
                }
            )
        }*/


    }
}

