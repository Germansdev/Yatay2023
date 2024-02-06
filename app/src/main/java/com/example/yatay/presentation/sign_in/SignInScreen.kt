package com.example.yatay.presentation.sign_in

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


@Composable
fun SignInScreen(
    state: SignInState,
    onSignInClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    modifier.background(Color.White)
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

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .background(Color.White)

            .padding(
                start = 22.dp, end = 22.dp,
                top = 50.dp
            ),
    ) {

       Button(
            colors = ButtonDefaults.buttonColors(
                containerColor= Color.White,
                contentColor = Color.DarkGray,
                disabledContainerColor= Color.Gray,
                disabledContentColor= Color.White
            ),
            elevation= ButtonDefaults.elevatedButtonElevation(
                defaultElevation= 5.dp,
                pressedElevation = 10.dp,
                focusedElevation = 8.dp,
                hoveredElevation = 12.dp,
                disabledElevation= 3.dp

            ),
            modifier= Modifier.fillMaxWidth(),
            onClick = {  },
        ) {

            Text(text = "Sign in with E-mail",
                //color = Color.Black
            )
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .size(10.dp))
        Box(modifier = Modifier ){

            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor= Color.White,
                    contentColor = Color.DarkGray,
                    disabledContainerColor= Color.Gray,
                    disabledContentColor= Color.White
                ),
                elevation= ButtonDefaults.elevatedButtonElevation(
                    defaultElevation= 5.dp,
                    pressedElevation = 10.dp,
                    focusedElevation = 8.dp,
                    hoveredElevation = 12.dp,
                    disabledElevation= 3.dp

                ),
                modifier= Modifier.fillMaxWidth(),
                onClick = onSignInClick
            ) {
                Text(text = "Sign in with Google")
            }
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .size(10.dp))
        Button(
            elevation= ButtonDefaults.elevatedButtonElevation(
                defaultElevation= 5.dp,
                pressedElevation = 10.dp,
                focusedElevation = 20.dp,
                hoveredElevation = 12.dp,
                disabledElevation= 5.dp

            ),
            colors = ButtonDefaults.buttonColors(
                containerColor= Color.White,
                contentColor = Color.DarkGray,
                disabledContainerColor= Color.Gray,
                disabledContentColor= Color.White
            ),
            modifier= Modifier.fillMaxWidth(),
            onClick = {}
        ) {
            Text(text = "Sign in with Facebook")
        }

    }

}