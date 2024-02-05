package com.example.yatay.model

class Reserves (
    val dateIn: String ="",
    val dateOut: String = "",
    val totalVisitors: Int = 0,
    val totalChildren : Int = 0,
){
    fun getReserves () = Reserves(dateIn, dateOut, totalVisitors, totalChildren)
}