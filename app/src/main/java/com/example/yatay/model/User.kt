package com.example.yatay.model

import com.example.yatay.presentation.sign_in.UserData

data class User (
    val name: String = "",
    val grandName : String ="",
    val dni : String = "",
    val phone : String = "",
    val reserves: Reserves,
    val user: UserData,
) {
   fun getUser () = User(name, grandName,dni, phone, reserves,user = user)
}