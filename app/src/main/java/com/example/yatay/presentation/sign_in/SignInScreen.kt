package com.example.yatay.presentation.sign_in

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


@Composable
fun SignInScreen(
    state: SignInState,
    onSignInClick: () -> Unit
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = state.signInError) {
        state.signInError?.let { error ->
            Toast.makeText(
                context,
                error,
                Toast.LENGTH_LONG
            ).show()
        }
    }

 /**   Box(modifier = Modifier ){

        OutlinedButton(
            modifier= Modifier.fillMaxWidth(),
            onClick = onSignInClick) {

            Text(text = "Sign in with Google")
        }
    }*/

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier

           // .fillMaxSize()
           // .size(300.dp)
            .padding(start = 8.dp, end = 8.dp,
                top = 200.dp
                ),

       // contentAlignment = Alignment.Center
    ) {

        OutlinedButton(
            shape = ShapeDefaults.ExtraLarge.copy(CornerSize(8.dp)),
            modifier= Modifier.fillMaxWidth(),
            onClick = {  }) {
           
           // Icon(imageVector = Icons.Outlined, contentDescription = )

            Text(text = "Sign in with E-mail")
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .size(10.dp))
        Box(modifier = Modifier ){

            OutlinedButton(
                modifier= Modifier.fillMaxWidth(),
                onClick = onSignInClick) {

                Text(text = "Sign in with Google")
            }
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .size(10.dp))
        OutlinedButton(
            modifier= Modifier.fillMaxWidth(),
            onClick = {}
        ) {
            Text(text = "Sign in with Facebook")
        }

    }

}