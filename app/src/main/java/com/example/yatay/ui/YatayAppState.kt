package com.example.yatay.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.yatay.navigation.BottomBarScreen
import com.example.yatay.navigation.BottomBarScreen.*


@Composable
fun rememberYatayAppState(
    navController: NavHostController = rememberNavController(),
    context: Context = LocalContext.current,
    windowSizeClass: WindowSizeClass,
): YatayAppState {
    return remember (
        navController,
        context,
        windowSizeClass
    ){
        YatayAppState(
            navController,
            context,
            windowSizeClass
        )
    }
}


class YatayAppState(
    val navController: NavHostController,
    private val context: Context,
    val windowSizeClass: WindowSizeClass,

) {



    var isOnline by mutableStateOf(checkIfOnline())
        private set

    fun refreshOnline() {
        isOnline = checkIfOnline()
    }
    @Suppress("DEPRECATION")
    private fun checkIfOnline(): Boolean {
        val cm = ContextCompat.getSystemService(context, ConnectivityManager::class.java)

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val capabilities = cm?.getNetworkCapabilities(cm.activeNetwork) ?: return false
            capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                    capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
        } else {
            cm?.activeNetworkInfo?.isConnectedOrConnecting == true
        }
    }


    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: BottomBarScreen?
        @Composable get() = when (currentDestination?.route) {
            Pantalla1.route -> Pantalla1
            Pantalla2.route -> Pantalla2
            Pantalla3.route -> Pantalla3
            Pantalla4.route -> Pantalla4
            Pantalla5.route -> Pantalla5
            else -> null
        }

    val shouldShowBottomBar: Boolean
        get() = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact

    val shouldShowNavRail: Boolean
        get() = !shouldShowBottomBar

    val bottomBarScreens: List<BottomBarScreen> = listOf(
        Pantalla1, Pantalla2, Pantalla3, Pantalla4, Pantalla5
    )

    fun navigateToBottomBarScreen(bottomBarScreen: BottomBarScreen) {

        /**val bottomBarScreens/**topLevelNavOptions*/ =*/
        navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }

        when (bottomBarScreen) {
            Pantalla1 -> navController.navigate(bottomBarScreen.route)
            Pantalla2 -> navController.navigate(bottomBarScreen.route)
            Pantalla3 -> navController.navigate(bottomBarScreen.route)
            Pantalla4 -> navController.navigate(bottomBarScreen.route)
            Pantalla5 -> navController.navigate(bottomBarScreen.route)
        }
    }



}
