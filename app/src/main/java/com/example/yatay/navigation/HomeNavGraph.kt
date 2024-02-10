package com.example.yatay.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.yatay.ui.YatayAppState
import com.example.yatay.ui.screens.DateRangePicker
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
            ScreenHome(
                onClick = {navController.navigate(Graph.DETAILS)}
            )
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
        /**
         * OPTION 1 : with NavOption similar to Search or with Args (PENDING):
         */
       /** composable(route=DatePickerScreenDestination.route){
            Bananos( onClick = { navController.navigateToDateRangePicker() })
        }
        composable(route = DatePickerScreenDestination.route){
            DateRangePicker()
        }*/




        detailsNavGraph(navController = navController)


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


@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.dateRangePicker.route
    ) {
composable(route = DetailsScreen.dateRangePicker.route){
    DateRangePicker(
        onClick = {
            //navController.popBackStack()
            //navController.navigate(Graph.HOME)
            navController.navigate(BottomBarScreen.Pantalla3.route)
            },
        onDismiss = {navController.popBackStack()}
    )
}

    }
}


sealed class DetailsScreen(val route: String) {
    object dateRangePicker: DetailsScreen(route = "DATEPICKER")
    object Information : DetailsScreen(route = "INFORMATION")
    object Overview : DetailsScreen(route = "OVERVIEW")
    //  object MiniProfile : AuthScreen(route = "MINIPROFILE")
}
