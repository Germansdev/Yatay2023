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


   // val navController = appState.navController
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = startDestination,
        modifier = modifier,
    ) {
/**
        composable("sign_in") {
            val viewModel = viewModel<SignInViewModel>()
            val state by viewModel.state.collectAsStateWithLifecycle()

            LaunchedEffect(key1 = Unit) {
                if (googleAuthUiClient.getSignedInUser() != null) {
                    //navController.navigate("profile")
                    navController.navigate("HOME-SCREEN")
                }
            }

            val launcher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.StartIntentSenderForResult(),
                onResult = { result ->
                    if (result.resultCode == ComponentActivity.RESULT_OK) {
                        lifecycleScope.launch {
                            val signInResult = googleAuthUiClient.signInWithIntent(
                                intent = result.data ?: return@launch
                            )
                            viewModel.onSignInResult(signInResult)
                        }

                    }
                }
            )

            LaunchedEffect(key1 = state.isSignInSuccessful) {
                if (state.isSignInSuccessful) {
                    Toast.makeText(

                        applicationContext,
                        "Sign in successful",
                        Toast.LENGTH_LONG
                    ).show()

                    navController.navigate("profile")
                    viewModel.resetState()
                }
            }

            SignInScreen(
                state = state,
                onSignInClick = {
                    lifecycleScope.launch {
                        val signInIntentSender = googleAuthUiClient.signIn()
                        launcher.launch(
                            IntentSenderRequest.Builder(
                                signInIntentSender ?: return@launch
                            ).build()
                        )
                    }
                }
            )
        }

        composable("profile") {
            ProfileScreen(
                userData = googleAuthUiClient.getSignedInUser(),
                onSignOut = {
                    lifecycleScope.launch {
                        googleAuthUiClient.signOut()
                        Toast.makeText(
                            applicationContext,
                            "Signed out",
                            Toast.LENGTH_LONG
                        ).show()

                        navController.popBackStack()
                    }
                }
            )
        }*/

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