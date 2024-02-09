package com.example.yatay.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.yatay.ui.YatayAppState
import com.example.yatay.ui.screens.Bananos
import com.example.yatay.ui.screens.DatePickerScreenDestination
import com.example.yatay.ui.screens.DateRangePicker
import com.example.yatay.ui.screens.ScreenGallery
import com.example.yatay.ui.screens.ScreenHome
import com.example.yatay.ui.screens.ScreenMap
import com.example.yatay.ui.screens.ScreenMessages
import com.example.yatay.ui.screens.ScreenReserve
import com.example.yatay.ui.screens.navigateToDateRangePicker


sealed class DetailsScreen(val route: String) {
    object Information : DetailsScreen(route = "INFORMATION")
    object Overview : DetailsScreen(route = "OVERVIEW")
    //  object MiniProfile : AuthScreen(route = "MINIPROFILE")
}

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
            ScreenHome( )
        }
        composable(route = BottomBarScreen.Pantalla2.route) {
            ScreenMap(
                onClick = { navController.navigate(BottomBarScreen.Pantalla1.route)}
            )
        }
        composable(route = BottomBarScreen.Pantalla3.route) {
            ScreenReserve()
        }
        composable(route = BottomBarScreen.Pantalla4.route) {
            ScreenGallery()
        }
        composable(route = BottomBarScreen.Pantalla5.route) {

        /**    var isMapLoaded by remember { mutableStateOf(false) }
            if (!isMapLoaded) {
                AnimatedVisibility(
                    modifier = Modifier,
                       // .matchParentSize(),
                    visible = !isMapLoaded,
                    enter = EnterTransition.None,
                    exit = fadeOut()
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.background)
                            .wrapContentSize()
                    )

                }
            } else{*/
                ScreenMessages()
          //  }


        }

        composable(route=DatePickerScreenDestination.route){
            Bananos( onClick = { navController.navigateToDateRangePicker() })
        }
        composable(route = DatePickerScreenDestination.route){
            DateRangePicker()
        }
        //detailsNavGraph(navController = navController)


    /**    composable(route = Graph.DETAILS) {
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
                    navController.popBackStack()
                    // navController.navigate(Graph.DETAILS)
                    navController.navigate(Graph.AUTHENTICATION)
                }
            )
        }*/
    }
}

/**
fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.MiniProfile.route
    ) {
        composable(route = DetailsScreen.MiniProfile.route){
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

                    navController.popBackStack()
                   // navController.navigate(Graph.DETAILS)
                    //navController.navigate(Graph.AUTHENTICATION)
                }
            )
        }

    }
}*/


