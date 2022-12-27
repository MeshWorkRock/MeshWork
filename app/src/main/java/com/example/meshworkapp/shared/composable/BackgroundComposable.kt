package com.example.meshworkapp.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meshworkapp.R
import com.example.meshworkapp.ui.theme.GradientHigh
import com.example.meshworkapp.ui.theme.GradientLow



@Composable
fun HomeBackGround() {

    Box (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.home),
            contentDescription = "Home Background",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                        .fillMaxSize()

        )
    }
}

@Composable
fun LoginBackground() {

    Box (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Home Background",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxSize()

        )
    }
    
}

@Composable
fun StudentListBackground() {

    Box (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.student_list),
            contentDescription = "Home Background",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxSize()

        )
    }

}

@Composable
fun AnnouncementBackground() {

    Box (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.announcements),
            contentDescription = "Home Background",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxSize()

        )
    }

}

@Composable
fun TimeTableBackground() {

    Box (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.time_table),
            contentDescription = "Home Background",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxSize()

        )
    }

}

@Composable
fun CreateAnnouncementBackground() {

    Box (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.create_announcements),
            contentDescription = "Home Background",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxSize()

        )
    }
}

//@Composable
//fun CardBackground() : Brush {
//
//    val cardBackground : Brush = Brush.horizontalGradient(
//        colors = listOf(
//            GradientLow,
//            GradientHigh
//        )
//    )
//
//    return cardBackground
//
//}







@Preview(showBackground = true)
@Composable
fun MyUIPreview(){
//    CardBackground()
}