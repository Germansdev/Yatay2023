package com.example.yatay.navigation

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MapsUgc
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.PhotoAlbum
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.yatay.R

sealed class BottomBarScreen (
    val titleTextId: Int,
    val route: String,
    var iconTextId: Int,
    val unselectedIcon: Icon,
    val selectedIcon: Icon,
){

    object Pantalla1: BottomBarScreen(
        titleTextId = R.string.home,
        route = "HOME-SCREEN",
        iconTextId = R.string.home,
        unselectedIcon = Icon.ImageVectorIcon(YatayIcons.Home),
        selectedIcon = Icon.ImageVectorIcon(YatayIcons.Home),
    )
    object Pantalla2: BottomBarScreen(
        titleTextId = R.string.map,
        route = "MAP-SCREEN",
        iconTextId = R.string.map,
        unselectedIcon = Icon.ImageVectorIcon(YatayIcons.Map),
        selectedIcon = Icon.ImageVectorIcon(YatayIcons.Map),
    )
    object Pantalla3: BottomBarScreen(
        titleTextId = R.string.reserve,
        route = "RESERVE-SCREEN",
        iconTextId = R.string.reserve,
        unselectedIcon = Icon.ImageVectorIcon(YatayIcons.Reserve),
        selectedIcon = Icon.ImageVectorIcon(YatayIcons.Reserve),
    )

    object Pantalla4: BottomBarScreen(
        titleTextId = R.string.gallery,
        route = "GALLERY-SCREEN",
        iconTextId = R.string.gallery,
        unselectedIcon = Icon.ImageVectorIcon(YatayIcons.Gallery),
        selectedIcon = Icon.ImageVectorIcon(YatayIcons.Gallery),
    )
    object Pantalla5: BottomBarScreen(
        titleTextId = R.string.messages,
        route = "MESSAGES-SCREEN",
        iconTextId = R.string.messages,
        unselectedIcon = Icon.ImageVectorIcon(YatayIcons.Messages),
        selectedIcon = Icon.ImageVectorIcon(YatayIcons.Messages),
    )


}

object YatayIcons {
    val Home = Icons.Outlined.Home
    val HomeBorder = Icons.Outlined.Home
    val Map = Icons.Outlined.MapsUgc
    val Reserve = Icons.Outlined.AddShoppingCart
    val Gallery = Icons.Outlined.PhotoAlbum
    val Messages = Icons.Outlined.Message




}

sealed class Icon {
    data class ImageVectorIcon (val imageVector: ImageVector) : Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}