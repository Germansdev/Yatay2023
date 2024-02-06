package com.example.yatay.ui.screens

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.yatay.R
import com.example.yatay.model.HomeCategory

@Composable
fun ScreenHome (
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
    ){

    val viewState by viewModel.state.collectAsStateWithLifecycle()

    Surface(Modifier.fillMaxSize()
        //.background(Color.White)
    ) {
        HomeContent(
            isRefreshing = viewState.refreshing,
            homeCategories = viewState.homeCategories,
            selectedHomeCategory = viewState.selectedHomeCategory,
            onCategorySelected = viewModel::onHomeCategorySelected,
           // navigateToPlayer = navigateToPlayer,
            modifier = Modifier.fillMaxSize()
        )
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(
    isRefreshing: Boolean,
    selectedHomeCategory: HomeCategory,
    homeCategories: List<HomeCategory>,
    modifier: Modifier = Modifier,
    onCategorySelected: (HomeCategory) -> Unit,
   // navigateToPlayer: (String) -> Unit //implement videoplayer

) {


    Column(
        modifier = modifier.windowInsetsPadding(
            WindowInsets.systemBars.only(WindowInsetsSides.Horizontal)
        )
          //  .background(Color.White)

    ){
            val surfaceColor = Color.White
           // val appBarColor = surfaceColor.copy(alpha = 0.87f)

        if (isRefreshing) {
            // TODO show a progress indicator or similar
        }

        if (homeCategories.isNotEmpty()) {

                HomeCategoryTabs(
                    categories = homeCategories,
                    selectedCategory = selectedHomeCategory,
                    onCategorySelected = onCategorySelected,
                    )
        }

        when (selectedHomeCategory) {
            HomeCategory.Naranjos -> {

                Text(text = "navigate to viewplayer and show video naranjos")
            }

            HomeCategory.Bananos -> {
            /**   (
                    navigateToPlayer = navigateToPlayer,
                    Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )*/
                Text(text = "navigate to viewplayer and show video bananos" )
            }

            HomeCategory.Roble -> {    }
        }
        }


}

@Composable
private fun HomeCategoryTabs(
    categories: List<HomeCategory>,
    selectedCategory: HomeCategory,
    onCategorySelected: (HomeCategory) -> Unit,
    modifier: Modifier = Modifier
) {
    modifier.background(Color.White)
    val selectedIndex = categories.indexOfFirst { it == selectedCategory }
    val indicator = @Composable { tabPositions: List<TabPosition> ->
        HomeCategoryTabIndicator(
            Modifier.tabIndicatorOffset(tabPositions[selectedIndex])
        )
    }
Column(modifier= Modifier
    .fillMaxHeight()
    .background(Color.White)



) {
    TabRow(
        selectedTabIndex = selectedIndex,
        indicator = indicator,

        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 15.dp, bottom = 1.dp)

        ,

           //.height(30.dp),

        containerColor = Color.White//Color.White
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
                            HomeCategory.Roble -> stringResource(id = R.string.roble)
                        },
                        style = MaterialTheme.typography.bodyLarge,
                        color = if (index==selectedIndex) Color.Black else Color.DarkGray,
                        fontWeight = if (index==selectedIndex ) FontWeight.Bold else FontWeight.Normal,//if(index ==selectedIndex) Color.DarkGray else Color.LightGray,
                    )
                },
                unselectedContentColor = Color.Gray,
                selectedContentColor = Color.Black

            )
        }
    }
}
    Log.d(ContentValues.TAG, selectedCategory.name)
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