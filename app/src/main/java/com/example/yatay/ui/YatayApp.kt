package com.example.yatay.ui

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults.colors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.example.yatay.navigation.BottomBarScreen
import com.example.yatay.navigation.HomeNavGraph
import com.example.yatay.navigation.Icon
import com.example.yatay.presentation.profile.MiniProfile
import com.example.yatay.presentation.sign_in.GoogleAuthUiClient
import com.google.android.gms.auth.api.identity.Identity


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun YatayApp(
    appState: YatayAppState,
    modifier: Modifier = Modifier
) {
//YatayBackground{
   // modifier.background(Color.White)

    Scaffold(
        modifier = Modifier,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        containerColor = Color.White,
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
                //.background(Color.White)
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
            /** appState.navController.navigateToSearch() */
            Column(Modifier.fillMaxWidth()
               // .background(Color.White)
            ) {
//Row(modifier= Modifier.background(Color.White)) {
Row (modifier = Modifier.fillMaxWidth()

) {



                val destination = appState.currentTopLevelDestination
                if (destination != null) {
                    /** appState.navController.navigateToSearch() */
                   /** appState.navController.navigateToSearch() */
                    ElevatedCard (
                        shape = CircleShape,//RoundedCornerShape(25.dp),

                        elevation = CardDefaults.cardElevation(15.dp
                            /**    defaultElevation= 5.dp,
                            pressedElevation= 1.dp,
                        focusedElevation= 10.dp,
                     hoveredElevation= 10.dp,
                    draggedElevation = 10.dp,
                    disabledElevation = 3.dp*/
                        /**    defaultElevation= 5.dp,
                            pressedElevation= 1.dp,
                        focusedElevation= 10.dp,
                     hoveredElevation= 10.dp,
                    draggedElevation = 10.dp,
                    disabledElevation = 3.dp*/
                        ),
                        colors= CardDefaults.cardColors(
                            containerColor=Color.White,
                        contentColor= Color.White,
                    disabledContainerColor= Color.LightGray,
                    disabledContentColor= Color.LightGray
                        ),
                        modifier = Modifier
                            // .fillMaxWidth()
                            // .fillMaxHeight()
                            .size(width = 320.dp, height = 70.dp)
                            .padding(top = 6.dp, bottom = 6.dp, start = 24.dp, end = 4.dp),
                           // .clip(RoundedCornerShape(25.dp))
                    ){

                    CustomTopBar(
                        titleRes = destination.titleTextId,
                        navigationIcon = Icons.Outlined.Search,
                        navigationIconContentDescription = null,
                        actionIcon = Icons.Outlined.Settings,
                        actionIconContentDescription = null,
                        colors = TopAppBarDefaults
                            .centerAlignedTopAppBarColors(
                                // titleContentColor = GamesNavigationDefaults.navigationSelectedItemColor(),
                                containerColor = Color.White,
                            ),
                        onActionClick = { },
                        onNavigationClick = {/** appState.navController.navigateToSearch() */},
                    )
                    }

                    }
    Spacer(modifier = Modifier.size(12.dp))
   /**  remember{
        val  googleAuthUiClient: GoogleAuthUiClient,
    }*/


        //= UserData(userId = userData.userId, username = ,profilePictureUrl = userData.profilePictureUrl)
    val applicationContext: Context = LocalContext.current
   val googleAuthUiClient by lazy {
       GoogleAuthUiClient(
           context = applicationContext,
           oneTapClient = Identity.getSignInClient(applicationContext)
       )
   }
Card (
    colors = CardDefaults.cardColors(containerColor = Color.Transparent, contentColor = Color.DarkGray),
    shape = CircleShape,
    modifier = Modifier
        .background(Color.White)
        .align(Alignment.CenterVertically)
        //.align(Alignment.CenterHorizontally)
        .wrapContentSize()
        //.padding(4.dp)
        .size(48.dp)
        .clickable { }

){

    MiniProfile(

        googleAuthUiClient.getSignedInUser(),
        onClick = {},
        Modifier
            .size(width = 48.dp, height = 48.dp)
            .padding(8.dp)
            .clip(CircleShape)
    )
}
                }
                if (appState.isOnline) {
                    val navController = appState.navController

                    HomeNavGraph(appState = appState, navController = navController)

                } else {
                    Text(
                        color =Color.Gray,
                        text = "hey connect to internet")
                }
            }
            }
        }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(
    //with CenterAlignedTopAppBar:
    modifier: Modifier = Modifier,
    @StringRes titleRes: Int,

    navigationIcon: ImageVector?,
    navigationIconContentDescription: String?,
    actionIcon: ImageVector,
    actionIconContentDescription: String?,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
    onNavigationClick: () -> Unit = {},
    onActionClick: () -> Unit = {},

    ) {
    //With CenterAlignedTopAppBar:
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = titleRes),
                fontSize = 16.sp,
            )
        },
        navigationIcon = {

            IconButton(onClick = onNavigationClick) {
                if (navigationIcon != null) {
                    Icon(
                        imageVector = navigationIcon,
                        contentDescription = navigationIconContentDescription,
                        tint = MaterialTheme.colorScheme.onSurface,
                    )
                }
            }
        },
        actions = {
            IconButton(onClick = onActionClick) {
                Icon(
                    imageVector = actionIcon,
                    contentDescription = actionIconContentDescription,
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
        },
        colors = colors,
        modifier = modifier,
    )
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
  Divider(
      color= Color.Gray,
  )
    NavigationBar(
        containerColor = Color.Transparent,
        modifier = modifier.background(Color.Transparent)
    ) {

        destinations.forEach { screen ->
            NavigationBarItem(
                selected = currentDestination.isTopLevelDestinationInHierarchy(screen),
                onClick = { onNavigateToDestination(screen) },
                colors = colors(
                    selectedIconColor =  Color.Black,
                    selectedTextColor =  Color.Black,
                    indicatorColor = Color.White ,
                    unselectedTextColor = Color.Gray,
                    unselectedIconColor = Color.Gray)
                ,
                icon = {
                    val icon: Icon =
                        if (currentDestination.isTopLevelDestinationInHierarchy(screen)) {
                            screen.selectedIcon
                        } else {
                            screen.unselectedIcon
                        }
                    when (icon) {
                        is Icon.ImageVectorIcon -> Icon(
                            imageVector = icon.imageVector,
                            contentDescription = null,
                        )

                        is Icon.DrawableResourceIcon -> Icon(
                            painter = painterResource(id = icon.id),
                            contentDescription = null,
                        )
                    }
                },
                label = {
                    Text(
                        text = stringResource(id = screen.titleTextId),
                        fontWeight = if (currentDestination.isTopLevelDestinationInHierarchy(screen)) (FontWeight.Bold ) else (FontWeight.Normal) ,
                        fontSize = 12.sp,
                        softWrap = false,
                        color = if (currentDestination.isTopLevelDestinationInHierarchy(screen)) Color.Black else  Color.Gray
                    )

                },

                modifier = Modifier.sizeIn(8.dp, 10.dp),
            )
        }
    }
}

