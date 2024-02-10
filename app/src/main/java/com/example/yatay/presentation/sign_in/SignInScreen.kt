package com.example.yatay.presentation.sign_in

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.twotone.Email
import androidx.compose.material.icons.twotone.Facebook
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.yatay.R


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

        Text(
            text = "Welcome to Yatay",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge,
            )
        Spacer(modifier = Modifier.size(20.dp))
        AsyncImage(
            model = R.drawable.muellediacartelperro,
            contentDescription = "Profile picture",
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.size(80.dp))

       Button(
            colors = ButtonDefaults.buttonColors(
                containerColor= Color.Black,
                contentColor = Color.White,
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
            modifier= Modifier.width(250.dp),
            onClick = {  },
        ) {
          Row (horizontalArrangement = Arrangement.Start,
          modifier= Modifier.padding(0.dp).width(width =20.dp)){
              Icon(imageVector = Icons.TwoTone.Email, contentDescription =null )
           }

           Spacer(modifier = Modifier.size(10.dp))
           Row(horizontalArrangement = Arrangement.Start,
               modifier= Modifier.padding(0.dp).width(150.dp)) {
               Text(text = "Sign in with E-mail",

               )
           }

        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .size(10.dp))
        Box(modifier = Modifier ){

            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor= Color.Black,
                    contentColor = Color.White,
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
                modifier= Modifier.width(250.dp),
                onClick = onSignInClick
            ) {
                Row (horizontalArrangement = Arrangement.Start,
                    modifier= Modifier.padding(0.dp).width(width =20.dp)) {
                    Icon(imageVector = Icons.Filled.Error, contentDescription = null)
                }
                Spacer(modifier = Modifier.size(10.dp))
                Row(horizontalArrangement = Arrangement.Start,
                    modifier= Modifier.padding(0.dp).width(150.dp)) {
                    Text(text = "Sign in with Google")
                }
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
                containerColor= Color.Black,
                contentColor = Color.White,
                disabledContainerColor= Color.Gray,
                disabledContentColor= Color.White
            ),
            modifier= Modifier.width(250.dp),
            onClick = {}
        ) {
            Row (horizontalArrangement = Arrangement.Start,
                modifier= Modifier.padding(0.dp).width(width =20.dp)) {
                Icon(imageVector = Icons.TwoTone.Facebook, contentDescription = null)
            }
            Spacer(modifier = Modifier.size(10.dp))
            Row(horizontalArrangement = Arrangement.Start,
                modifier= Modifier.padding(0.dp).width(150.dp)) {
                Text(text = "Sign in with Facebook")
            }
        }

    }

}