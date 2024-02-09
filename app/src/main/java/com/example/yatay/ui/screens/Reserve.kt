package com.example.yatay.ui.screens

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenReserve(){

    //Bottom sheet doesn´t work with bottom bar 
/**
val scope = rememberCoroutineScope()
val scaffoldState = rememberBottomSheetScaffoldState()

BottomSheetScaffold(
scaffoldState = scaffoldState,
sheetPeekHeight = 128.dp,
sheetContent = {
    Box(
        Modifier
            .fillMaxWidth()
            .height(128.dp),
        contentAlignment = Alignment.Center
    ) {
        Text("Swipe up to expand sheet")
    }
    Column(
        Modifier
            .fillMaxWidth()
            .padding(64.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Sheet content")
        Spacer(Modifier.height(20.dp))
        Button(
            onClick = {
                scope.launch { scaffoldState.bottomSheetState.partialExpand() }
            }
        ) {
            Text("Click to collapse sheet")
        }
    }
}) { innerPadding ->
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        contentAlignment = Alignment.Center
    ) {
        Text("Scaffold Content")
    }
}*/

    Text(
        color = if (isSystemInDarkTheme()) Color.White else Color.Black,
        text = "Reserve")
}
