package com.example.meshworkapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.text.DateFormatSymbols
import java.util.*

@Composable
fun TimeTableComposable() {
    val dayNames: Array<String> = DateFormatSymbols().weekdays
    val date: Calendar = Calendar.getInstance()
    val currentDay: String = dayNames[date.get(Calendar.DAY_OF_WEEK)]

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        DayChipComposable(currentDay)
    }

}


@Composable
fun DayChipComposable(currentDay: String) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val chipBackgroundColor = if (isPressed) Color.Blue else Color.Gray


    val selectedColor : Color = Color.Blue

    var selectedDay by remember {
        mutableStateOf(currentDay)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        LazyRow {
            itemsIndexed(
                listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")
            ) { index, string ->
                Button(
                    onClick = {
                        selectedDay = string
                    },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(backgroundColor = chipBackgroundColor),
                    modifier = Modifier.padding(end = 3.dp)
                ) {
                    Text(text = string)
                }

            }
        }
    }
}

@Composable
fun sampleComposable(){
    Text(text = "sahil")
}


@Preview(showBackground = true)
@Composable
fun TimeTablePreview() {
    TimeTableComposable()
}
