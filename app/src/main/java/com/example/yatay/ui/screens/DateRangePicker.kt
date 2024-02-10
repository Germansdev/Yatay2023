package com.example.yatay.ui.screens

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.util.Calendar


/**
 *option 1: with navOption? similar to Search from Top Bar? doesn´t work yet or with Args (PENDING):
 *
const val datePickerRoute = "date_picker_route"

object DatePickerScreenDestination : NavigationDestination {
override val route: String = "date_picker_route"
override val titleRes: Int = R.string.date_picker
}

fun NavController.navigateToDateRangePicker(navOptions: NavOptions? = null) {
this.navigate(datePickerRoute, navOptions)
}*/

/**
 * option 2: with other GRAPH NESTED NAVIGATION:
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateRangePicker(
    onClick: ()->Unit,
    onDismiss: ()->Unit
) {

// Decoupled snackbar host state from scaffold state for demo purposes.
   // val snackState = remember { SnackbarHostState() }
    val snackScope = rememberCoroutineScope()
  //  SnackbarHost(hostState = snackState, Modifier.zIndex(1f))
    val state = rememberDateRangePickerState()//rememberDateRangePickerState()
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {
        // Add a row with "Save" and dismiss actions.
        Row(
            modifier = Modifier

                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { onDismiss() }) {
                Icon(Icons.Filled.Close, contentDescription = "Localized description")
            }
            TextButton(
                onClick = {
                /**    snackScope.launch {
                        snackState.showSnackbar(
                            "Saved range (timestamps): " +
                                    "${state.selectedStartDateMillis!!..state.selectedEndDateMillis!!}"
                        )
                    }*/
                    onClick()
                },
                enabled = state.selectedEndDateMillis != null,
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color.Black)

            ) {
                Text(text = "Save")
            }
        }

        DateRangePicker(
            state = state,
            colors = DatePickerDefaults.colors(
                containerColor = Color.Blue,
                titleContentColor = Color.Black,
                headlineContentColor = Color.Black,
                weekdayContentColor = Color.Black,
                subheadContentColor = Color.Black,
                yearContentColor = Color.Green,
                currentYearContentColor = Color.Red,
                selectedYearContainerColor = Color.Red,
                disabledDayContentColor = Color.Gray,
                todayDateBorderColor = Color.Blue,
                dayInSelectionRangeContainerColor = Color.LightGray,
                dayInSelectionRangeContentColor = Color.White,
                selectedDayContainerColor = Color.Black
            ),
            modifier = Modifier.weight(1f))
    }
}

fun getFormattedDate(timeInMillis: Long): String{
    val calender = Calendar.getInstance()
    calender.timeInMillis = timeInMillis
    val dateFormat = SimpleDateFormat("dd/MM/yyyy")
    return dateFormat.format(calender.timeInMillis)
}
