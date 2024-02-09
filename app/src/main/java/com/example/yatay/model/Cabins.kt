package com.example.yatay.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.yatay.R
import java.text.NumberFormat


data class Cabins(
    val name: String = "Name",
    val capacity: String = "Capacity",
    val price: Double = 0.0,
    val viewLook: String = "View",
    val rating: Float = 0f,
    val isFavorite: Boolean = false,
    //val images: List<ImagesCabin>
//    val available: Boolean

) {
    /**
     * Getter method for price.
     * Includes formatting.
     */
    fun getFormattedPrice(i: Int): String = NumberFormat.getCurrencyInstance().format(price)
    fun getCabins() = Cabins(name, capacity, price, viewLook, rating, isFavorite)
}

/**
 * Repository previous to carry it to firebase/Mongo :
 */

object DataSource{

    val cabins = listOf(

                Cabins(
                    name = "Bananos",
                    capacity = ": 6 people 1 double bed and 4 singles",
                    viewLook = ": river view beautiful vegetation",
                    price = 25.000,
                )

    )


}

data class CabinsPictures(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)

class DataSourceLocal() {
    fun loadCabinsPictures(): List<CabinsPictures> {
        return listOf(
            CabinsPictures(R.string.bananos, R.drawable.bananos),
            CabinsPictures(R.string.collage, R.drawable.collage),
            CabinsPictures(R.string.diavistas, R.drawable.diavistas),
            CabinsPictures(R.string.fuego_asado, R.drawable.fuegoasado),
            CabinsPictures(R.string.duraznero, R.drawable.duraznero),
            CabinsPictures(R.string.muelle_d_a, R.drawable.muelle),
            CabinsPictures(R.string.muelle_d_a_cartel, R.drawable.muellediacartelperro),
            CabinsPictures(R.string.muellenoche2, R.drawable.muellenoche2),
            CabinsPictures(R.string.noche, R.drawable.noche),
            CabinsPictures(R.string.parrald_a, R.drawable.parraldia),
            CabinsPictures(R.string.parralnoche, R.drawable.parralnoche),
            CabinsPictures(R.string.pinacolada, R.drawable.pinacolada),
            CabinsPictures(R.string.roble2, R.drawable.roble),
            CabinsPictures(R.string.yataycartel, R.drawable.yataycartel),

            )
    }
}

enum class HomeCategory {
    Bananos,
    Naranjos,
    Roble
}

data class HomeViewState(
    //  val refreshing: Boolean = false,
    val selectedHomeCategory: HomeCategory = HomeCategory.Roble,
    val homeCategories: List<HomeCategory> = emptyList(),
    val errorMessage: String? = null
)


/**
data class HomeCategory (
val title: String,
val unselectedIcon: ImageVector,
val selectedIcon: ImageVector,
)*/

data class TabItem(
    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector,
    //val text:  @Composable () -> Unit = {}
) {

}






