package com.example.meshworkapp.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.meshworkapp.navigationgraphs.HubNavigationScreens

@Composable
fun ClassCardComposable(
    className: String,
    subjectName: String,
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
) {
    Card(
        modifier = modifier
            .padding(10.dp)
            .clickable {
                navHostController.navigate(HubNavigationScreens.StudentsList.route)
            },
        backgroundColor = Color.Yellow,
        elevation = 10.dp
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = className,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            )
            Text(
                text = subjectName,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ClassCardPreview() {
    ClassCardComposable(
        className = "22MCD-1",
        subjectName = "Digital Electronics",
        modifier = Modifier.size(200.dp),
        navHostController = NavHostController(LocalContext.current)
    )
}