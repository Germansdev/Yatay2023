package com.example.yatay.ui.screens

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
import androidx.compose.material3.DateRangePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import kotlinx.coroutines.launch


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
    val snackState = remember { SnackbarHostState() }
    val snackScope = rememberCoroutineScope()
    SnackbarHost(hostState = snackState, Modifier.zIndex(1f))
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
                    snackScope.launch {
                        snackState.showSnackbar(
                            "Saved range (timestamps): " /**+
                                    "${state.selectedStartDateMillis!!..state.selectedEndDateMillis!!}"*/

                        )
                    }
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
            title = { Text(text = "Select dates") },
            headline = {

                DateRangePickerDefaults.DateRangePickerHeadline(
                    selectedStartDateMillis =  state.selectedStartDateMillis ,
                    selectedEndDateMillis = state.selectedEndDateMillis,
                    displayMode = state.displayMode,
                    dateFormatter = remember { DatePickerDefaults.dateFormatter(
                        yearSelectionSkeleton =  "yy/MM",//"Start Date:" + if(state.selectedStartDateMillis!=null) state.selectedStartDateMillis?.let { getFormattedDate(it) } else "",
                        selectedDateSkeleton = "dd/MM",//"YYYY",
                       selectedDateDescriptionSkeleton = ""

                    )
                                             },

                    modifier = Modifier
                        .padding() )
            },
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
            showModeToggle = false,
            modifier = Modifier.weight(1f))
    }
}

/**
 * PENDING: SET LANGUAGE CALENDAR:
 */
/**
@ExperimentalMaterial3Api
fun DateRangePickerState(
    locale: CalendarLocale,
    initialSelectedStartDateMillis: Long? = null,
    initialSelectedEndDateMillis: Long? = null,
    initialDisplayedMonthMillis: Long? = initialSelectedStartDateMillis,
    yearRange: IntRange = DatePickerDefaults.YearRange,
    initialDisplayMode: DisplayMode = DisplayMode.Picker,
    selectableDates: SelectableDates = DatePickerDefaults.AllDates
): DateRangePickerState {
    locale = CalendarLocale(language = "")
}
*/