package com.example.meshworkapp

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.meshworkapp.Screen

@Composable
fun UserSelectionComposable(
    navController: NavHostController,
    onClick: () -> Unit
) {
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
                    onClick()
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

