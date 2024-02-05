package com.example.yatay.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults.colors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.example.yatay.navigation.BottomBarScreen
import com.example.yatay.navigation.HomeNavGraph
import com.example.yatay.navigation.Icon




@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun YatayApp(
    appState: YatayAppState
) {

    Scaffold(
        modifier = Modifier,
        containerColor = Color.Transparent,
        contentColor = Color.Transparent,
        bottomBar = {
            BottomBar(
                destinations = appState.bottomBarScreens,
                onNavigateToDestination = appState::navigateToBottomBarScreen,
                currentDestination = appState.currentDestination,
                modifier = Modifier.background(Color.Transparent),
            )
        }
    ) { padding ->

        Row(
            Modifier
                .fillMaxSize()
                .consumeWindowInsets(padding)
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(
                        WindowInsetsSides.Horizontal,
                    ),
                ),

            ) {

            if (appState.shouldShowNavRail) {
                YatayNavRail(
                    destinations = appState.bottomBarScreens,
                    onNavigateToDestination = appState::navigateToBottomBarScreen,
                    currentDestination = appState.currentDestination,

                    modifier = Modifier
                        .safeDrawingPadding()
                )
            }


            if (appState.isOnline) {
                val navController = appState.navController

             HomeNavGraph(appState = appState, navController = navController)

            } else {

                Text(
                     color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    text = "hey connect to internet")

            }
        }

    }
}

@Composable
fun YatayNavRail(
    destinations: List<BottomBarScreen>,
    onNavigateToDestination: (BottomBarScreen) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier
) {   }


fun NavDestination?.isTopLevelDestinationInHierarchy(destination: BottomBarScreen) =
    this?.hierarchy?.any {
        it.route?.contains((destination.route), true) ?: false
    } ?: false

@Composable
fun BottomBar(
    destinations: List<BottomBarScreen>,
    onNavigateToDestination : (BottomBarScreen) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier

    ) {
    NavigationBar(
        containerColor = Color.Transparent,
        modifier = modifier.background(Color.Transparent),
    ) {

        destinations.forEach { screen ->
            NavigationBarItem(
                selected = currentDestination.isTopLevelDestinationInHierarchy(screen),
                onClick = { onNavigateToDestination(screen) },
                colors = colors( selectedIconColor =  if (isSystemInDarkTheme()) Color.White else Color.Black,
                    selectedTextColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    indicatorColor = if (isSystemInDarkTheme()) Color.Gray else Color.White ,
                    unselectedTextColor = if (isSystemInDarkTheme()) Color.Gray else Color.Gray,
                    unselectedIconColor = if (isSystemInDarkTheme()) Color.Gray else Color.Gray,)
                ,
                icon = {
                    val icon: Icon =
                        if (currentDestination.isTopLevelDestinationInHierarchy(screen)) {
                            screen.selectedIcon
                        } else {
                            screen.unselectedIcon
                        }
                    when (icon) {
                        is Icon.ImageVectorIcon -> androidx.compose.material3.Icon(
                            imageVector = icon.imageVector,
                            contentDescription = null,
                        )

                        is Icon.DrawableResourceIcon -> androidx.compose.material3.Icon(
                            painter = painterResource(id = icon.id),
                            contentDescription = null,
                        )
                    }
                },
                label = {
                    Text(
                        text = stringResource(id = screen.titleTextId),
                        fontSize = 12.sp,
                        softWrap = false,
                        color = if (currentDestination.isTopLevelDestinationInHierarchy(screen)
                        ) {
                            if (isSystemInDarkTheme()) Color.White else Color.Black
                        } else {
                            if (isSystemInDarkTheme()) Color.Gray else Color.Gray
                        }
                    )
                },
                modifier = Modifier.sizeIn(8.dp, 10.dp),
            )
        }
    }
}

