package com.example.yatay.ui.screens


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.yatay.model.Cabins
import com.example.yatay.model.DataSourceLocal

@SuppressLint("SuspiciousIndentation")
@Composable
fun Roble(
    //homeCategory: HomeCategory,
    onClick: ()->Unit,
    modifier: Modifier = Modifier
) {

    val cabins: Cabins = Cabins()

    Column(
        modifier = Modifier

            .fillMaxWidth()
            .fillMaxHeight()
            .padding(end = 8.dp)
    ) {

        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(2.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent,
                contentColor = Color.White,
                disabledContainerColor = Color.LightGray,
                disabledContentColor = Color.LightGray
            ),

            modifier = Modifier
                .size(width = 400.dp, height = 400.dp)
                .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 8.dp),
        ) {

            CabinsList(
                cabinList = DataSourceLocal().loadCabinsPictures().subList(fromIndex = 9, toIndex = 13)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Bottom
        ) {


            Text(
                text = "Roble",
                modifier = Modifier
                    .padding(start = 16.dp),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {

            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = cabins.capacity,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = ": 4 people 1 double bed and 2 singles",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Row(

                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = cabins.viewLook,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = ": view of the poplar forest",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "Price",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = ": USD 25",
                    style = MaterialTheme.typography.bodyMedium,
                )
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.Bottom) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier
                            .size(20.dp)
                            .background(Color.Transparent)
                            .clip(CircleShape)
                            .clickable { }
                    )
                    Text(text = "rate 4.7 " ,modifier.padding(start = 28.dp))
                    Icon(imageVector = Icons.Filled.Star, contentDescription = null)
                }
            }
        }
    }
}
