package com.example.meshworkapp.ui.theme

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.meshworkapp.Screen

@Composable
fun UserSelection(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "AS A FACULTY",
            color = MaterialTheme.colors.primary,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .border(2.dp, MaterialTheme.colors.primary)
                .width(200.dp)
                .padding(horizontal = 15.dp, vertical = 10.dp)
                .clickable {
                    navController.navigate(Screen.LoginScreenFaculty.route)
                }
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "AS A STUDENT",
            fontSize = 24.sp,
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .border(2.dp, MaterialTheme.colors.primary)
                .width(200.dp)
                .padding(horizontal = 15.dp, vertical = 10.dp)
                .clickable {
                    navController.navigate(Screen.LoginScreenStudent.route)
                }
        )
    }
}

