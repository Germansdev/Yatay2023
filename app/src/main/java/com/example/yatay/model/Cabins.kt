package com.example.yatay.model

import android.widget.RatingBar
enum class HomeCategory {
    Bananos, Naranjos, Roble
}

data class Cabins (
    val name: String = "",
    val capacity: String ="",
    val price: String = "",
    val rating: Float = 0f,
    val isFavorite: Boolean = false
//    val available: Boolean

){
    fun getCabins () = Cabins(name, capacity, price, rating, isFavorite)
}

data class HomeViewState(
    val refreshing: Boolean = false,
    val selectedHomeCategory: HomeCategory = HomeCategory.Naranjos,
    val homeCategories: List<HomeCategory> = emptyList(),
    val errorMessage: String? = null
)


