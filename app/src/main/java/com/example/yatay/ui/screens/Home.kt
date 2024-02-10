package com.example.yatay.ui.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.outlined.Cabin
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.yatay.R
import com.example.yatay.model.HomeCategory

@Composable
fun ScreenHome(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    onClick: () -> Unit
) {
       val viewState by viewModel.state.collectAsStateWithLifecycle()

    Surface(
        Modifier

    ) {

        Column (
            modifier = Modifier
                .wrapContentSize()
                .background(Color.White)

        ) {


            // initial tab :
            var HomeCategory by remember {
                mutableIntStateOf(0)
            }
Column (modifier = Modifier
    .size(620.dp)
    .background(Color.Transparent)){

            HomeContent(
                homeCategories = viewState.homeCategories,
                selectedHomeCategory = viewState.selectedHomeCategory,
                onCategorySelected = viewModel::onHomeCategorySelected,
                modifier = Modifier,
                onClick = onClick
            )

}
            Row (modifier = Modifier
                .fillMaxSize()
                .padding(end = 16.dp, )
                ,
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Top

                ){
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .wrapContentSize(),
                    onClick = { onClick()  }
                ) {
                    Icon(imageVector = Icons.Filled.DateRange, contentDescription = null)
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(text = "Reserve")
                }
            }
        }
    }
    }

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(
    selectedHomeCategory: HomeCategory,
    homeCategories: List<HomeCategory>,
    onCategorySelected: (HomeCategory) -> Unit,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
/**    Column(
        modifier = modifier
            /**.windowInsetsPadding(
            WindowInsets.systemBars.only(WindowInsetsSides.Horizontal)
        )*/
        //  .background(Color.White)
            .background(Color.Red)
            .wrapContentSize() //prueba

    ) {*/
        val surfaceColor = Color.White
        // val appBarColor = surfaceColor.copy(alpha = 0.87f)

        if (homeCategories.isNotEmpty()) {

            HomeCategoryTabs(
                categories = homeCategories,
                selectedCategory = selectedHomeCategory,
                onCategorySelected = onCategorySelected,
                onClick = onClick

            )
        }


//    }
}

@Composable
private fun HomeCategoryTabs(
    categories: List<HomeCategory>,
    selectedCategory: HomeCategory,
    onCategorySelected: (HomeCategory) -> Unit,
    onClick: () -> Unit,

    modifier: Modifier = Modifier
) {
    modifier.background(Color.White)
    val selectedIndex = //categories.indexOf(HomeCategory.valueOf(selectedCategory.toString()))
    categories.indexOfFirst { it == selectedCategory }
    val indicator = @Composable { tabPositions: List<TabPosition> ->
        HomeCategoryTabIndicator(
            Modifier.tabIndicatorOffset(tabPositions[selectedIndex])
        )
    }
/**    Column(
        modifier = Modifier
            //.fillMaxHeight()
            .background(Color.Green )//background(Color.White)


    ) {*/
        TabRow(
            selectedTabIndex = selectedIndex,
            indicator = indicator,
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 15.dp, bottom = 1.dp),

            containerColor = Color.White
        ) {
            categories.forEachIndexed { index, category ->
                Tab(
                    selected = index == selectedIndex,
                    onClick = { onCategorySelected(category) },
                    text = {
                        Text(
                            text = when (category) {
                                HomeCategory.Bananos -> stringResource(R.string.bananos)
                                HomeCategory.Naranjos -> stringResource(R.string.naranjos)
                                HomeCategory.Roble -> stringResource( R.string.roble)
                            },
                            style = MaterialTheme.typography.bodyLarge,
                            color = if (index == selectedIndex) Color.Black else Color.DarkGray,
                            fontWeight = if (index == selectedIndex) FontWeight.Bold else FontWeight.Normal,//if(index ==selectedIndex) Color.DarkGray else Color.LightGray,
                        )
                    },
                    icon = {
                        when (category) {
                            HomeCategory.Bananos -> Icon(
                                imageVector = Icons.Outlined.Cabin,
                                contentDescription = null
                            )

                            HomeCategory.Naranjos -> Icon(
                                imageVector = Icons.Outlined.Cabin,
                                contentDescription = null
                            )

                            HomeCategory.Roble -> Icon(
                                imageVector = Icons.Outlined.Cabin,
                                contentDescription = null
                            )

                        }
                    },
                    unselectedContentColor = Color.Gray,
                    selectedContentColor = Color.Black
                )
            }
        }

if (selectedCategory==HomeCategory.Bananos){

        Bananos(onClick = {})


        //  Log.d("selectedCategory", HomeViewModel.selectedHomeCategory)
        Log.d("selected index", selectedIndex.toString())
        Log.d("indicator", indicator.toString())
        Log.d("selectedCategory", selectedCategory.name)

    }
        if (selectedCategory==HomeCategory.Naranjos){
            Naranjos(
                onClick = {}
            )
        }
        
        if (selectedCategory==HomeCategory.Roble){
            Roble(
                onClick = {}
            )
        }
//  }


}



@Composable
fun HomeCategoryTabIndicator(
    modifier: Modifier = Modifier,
    color: Color = Color.Black
) {
    Spacer(
        modifier
            .padding(horizontal = 34.dp, vertical = 0.dp)
            .height(2.dp)
            .background(color, RoundedCornerShape(topStartPercent = 100, topEndPercent = 100))
    )
}