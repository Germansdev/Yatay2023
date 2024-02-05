package com.example.yatay.model

import android.widget.RatingBar

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


