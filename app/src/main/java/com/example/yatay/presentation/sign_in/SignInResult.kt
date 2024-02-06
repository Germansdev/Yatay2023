package com.example.yatay.presentation.sign_in

import com.example.yatay.model.User

data class SignInResult(
    val data: UserData?,
    val errorMessage: String?
)

data class UserData(
    val userId: String,
    val username: String?,
    val profilePictureUrl: String?,
   // val user: User?
){
    //fun getUserData () = UserData(userId = userId, username = username, profilePictureUrl = profilePictureUrl)
}
