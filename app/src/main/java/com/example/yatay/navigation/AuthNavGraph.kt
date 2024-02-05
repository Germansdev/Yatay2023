package com.example.yatay.navigation

import android.content.Context
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.core.app.ComponentActivity
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.yatay.presentation.profile.ProfileScreen
import com.example.yatay.presentation.sign_in.GoogleAuthUiClient
import com.example.yatay.presentation.sign_in.SignInScreen
import com.example.yatay.presentation.sign_in.SignInState
import com.example.yatay.presentation.sign_in.SignInViewModel
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


fun NavGraphBuilder.authNavGraph(
    navController: NavHostController,
    applicationContext: Context,
    lifecycleScope: LifecycleCoroutineScope,

    googleAuthUiClient: GoogleAuthUiClient,
      ) {

/**    val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = applicationContext,
            oneTapClient = Identity.getSignInClient(applicationContext)
        )
    }*/

    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ) {
    /**    composable(route = AuthScreen.Login.route) {

            SignInScreen(
                state = SignInState(),
                onSignInClick = {
                    navController.popBackStack()
                    navController.navigate(AuthScreen.Profile.route)
                    //  navController.navigate(Graph.AUTHENTICATION)
                   // val userData: UserData? = ,
                  //  if (userData?.username != null) navController.navigate(Graph.HOME) else (" ")
                    // navController.navigate(Graph.HOME)
                },
            )
        }*/

        //}
        composable(route = AuthScreen.Login.route/**"sign_in"*/) {
            val viewModel = viewModel<SignInViewModel>()
            val state by viewModel.state.collectAsStateWithLifecycle()

            LaunchedEffect(key1 = Unit) {
                if (googleAuthUiClient.getSignedInUser() != null) {
                    navController.navigate(AuthScreen.Profile.route/**"profile"*/)
                    //navController.navigate("HOME-SCREEN")
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

                    navController.navigate(AuthScreen.Profile.route/**"profile"*/)
                    viewModel.resetState()
                /**    coroutineScope { //delay(5000)
                        navController.navigate(Graph.HOME)
                }*/


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
                    //navController.navigate(Graph.HOME)
                }
            )


        }

        composable(
            route = AuthScreen.Profile.route
            /**"profile"*/
        ) {
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
                },
                goHome = {
                    navController.navigate(Graph.HOME)
                }
            )
        }


    }
}

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen(route = "LOGIN")
    object Profile : AuthScreen(route = "SIGN_UP")
    //object Forgot : AuthScreen(route = "FORGOT")
}