package com.example.yatay.ui.screens
/**
import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePickerFormatter
import androidx.compose.material3.DateRangePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ComponentActivity
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar

/**
class DateTimeActivity : ComponentActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
setContent {
SampleDatePickerView()
}
}
}

title = {
Text(text = "Select date range to assign the chart", modifier = Modifier
.padding(16.dp))
},
headline = {
Row(modifier = Modifier.fillMaxWidth()
.padding(16.dp)) {
Box(Modifier.weight(1f)) {
(if(state.selectedStartDateMillis!=null) state.selectedStartDateMillis?.let { getFormattedDate(it) } else "Start Date")?.let { Text(text = it) }
}
Box(Modifier.weight(1f)) {
(if(state.selectedEndDateMillis!=null) state.selectedEndDateMillis?.let { getFormattedDate(it) } else "End Date")?.let { Text(text = it) }
}
Box(Modifier.weight(0.2f)) {
Icon(imageVector = Icons.Default.Done, contentDescription = "Okk")
}
}
}
 */



//@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SampleDatePickerView(){
    val state = rememberDateRangePickerState()
    //val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)//rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
   val scaffoldState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()

    BottomSheetScaffold(
        //sheetState = bottomSheetState,
        scaffoldState = scaffoldState,
        sheetContent = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp)
                    .background(Color.White)
            ) {
                DateRangePickerSample(state)
                Button(
                    onClick = {
                        coroutineScope.launch {
                            bottomSheetState.hide()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black, contentColor = Color.White),
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(end = 16.dp)
                ) {
                    Text("Done", color = Color.White)
                }
            }
        },
        content = {
            Column {
                Button(onClick = {
                    coroutineScope.launch {
                        bottomSheetState.show()
                    }
                }, modifier = Modifier.padding(16.dp)) {
                    Text(text = "Open Date Picker")
                }
                Text(text = "Start Date:" + if(state.selectedStartDateMillis!=null) state.selectedStartDateMillis?.let { getFormattedDate(it) } else "")
                Text(text = "End Date:" + if(state.selectedEndDateMillis!=null) state.selectedEndDateMillis?.let { getFormattedDate(it) } else "")
            }
        },
        scrimColor = Color.Black.copy(alpha = 0.5f),
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
    )
}
fun getFormattedDate(timeInMillis: Long): String{
    val calender = Calendar.getInstance()
    calender.timeInMillis = timeInMillis
    val dateFormat = SimpleDateFormat("dd/MM/yyyy")
    return dateFormat.format(calender.timeInMillis)
}

fun dateValidator(): (Long) -> Boolean {
    return {
            timeInMillis ->
        val endCalenderDate = Calendar.getInstance()
        endCalenderDate.timeInMillis = timeInMillis
        endCalenderDate.set(Calendar.DATE, Calendar.DATE + 20)
        timeInMillis > Calendar.getInstance().timeInMillis && timeInMillis < endCalenderDate.timeInMillis
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateRangePickerSample(state: DateRangePickerState){
    DateRangePicker(state,
        modifier = Modifier,
        dateFormatter = DatePickerFormatter("yy MM dd", "yy MM dd", "yy MM dd"),
        dateValidator = dateValidator(),
        title = {
            Text(text = "Select date range to assign the chart", modifier = Modifier
                .padding(16.dp))
        },
        headline = {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)) {
                Box(Modifier.weight(1f)) {
                    (if(state.selectedStartDateMillis!=null) state.selectedStartDateMillis?.let { getFormattedDate(it) } else "Start Date")?.let { Text(text = it) }
                }
                Box(Modifier.weight(1f)) {
                    (if(state.selectedEndDateMillis!=null) state.selectedEndDateMillis?.let { getFormattedDate(it) } else "End Date")?.let { Text(text = it) }
                }
                Box(Modifier.weight(0.2f)) {
                    Icon(imageVector = Icons.Default.Done, contentDescription = "Okk")
                }

            }
        },
        showModeToggle = true,
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
        )
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview16() {
    SampleDatePickerView()*/