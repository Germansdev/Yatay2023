package com.example.yatay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.example.yatay.navigation.RootNavigationGraph
import com.example.yatay.presentation.sign_in.GoogleAuthUiClient
import com.example.yatay.ui.theme.YatayTheme
import com.google.android.gms.auth.api.identity.Identity

//@AndroidEntryPoint
class MainActivity : ComponentActivity() {

     val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = applicationContext,
            oneTapClient = Identity.getSignInClient(applicationContext)
        )
    }

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YatayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val windowSize = calculateWindowSizeClass(this)
                    RootNavigationGraph(
                        navController = rememberNavController(),
                        googleAuthUiClient = googleAuthUiClient,
                        lifecycleScope,
                        applicationContext = applicationContext,
                        windowSize = windowSize,
                    )
                }
            }
        }
    }
}
