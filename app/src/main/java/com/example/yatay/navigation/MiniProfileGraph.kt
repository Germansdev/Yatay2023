package com.example.yatay.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.yatay.presentation.profile.MiniProfile
import com.example.yatay.presentation.sign_in.GoogleAuthUiClient
import com.example.yatay.presentation.sign_in.UserData
import com.google.android.gms.auth.api.identity.Identity

/**
sealed class MiniProfileGraph(val route: String) {

      object MiniProfile : MiniProfileGraph (route = "MINIPROFILE")
}
@Composable
fun MiniProfileGraph(
    navController: NavHostController,
   //googleAuthUiClient: GoogleAuthUiClient,
    ){
/**    navigation(
        route = Graph.MINI_PROFILE,
        startDestination = MiniProfileGraph.MiniProfile.route*/
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = MiniProfileGraph.MiniProfile.route)
     {
        composable(route = MiniProfileGraph.MiniProfile.route){
            val applicationContext: Context = LocalContext.current
            val googleAuthUiClient by lazy {
                GoogleAuthUiClient(
                    context = applicationContext,
                    oneTapClient = Identity.getSignInClient(applicationContext)
                )
            }
            MiniProfile(
                googleAuthUiClient.getSignedInUser(),
                onClick = {

                    //navController.popBackStack()

                    // navController.navigate(Graph.DETAILS)
                    //navController.navigate(Graph.AUTHENTICATION)
                }
            )
        }

    }


}*/

