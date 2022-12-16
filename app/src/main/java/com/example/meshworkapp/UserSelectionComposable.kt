package com.example.meshworkapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
import com.example.meshworkapp.composables.GradientBackGround
import com.example.meshworkapp.ui.theme.DarkBlueText

@Composable
fun UserSelectionComposable(
    navController: NavHostController,
    onClickFaculty: () -> Unit,
    onClickStudent: () -> Unit
) {


    Box {

        GradientBackGround()
        Column(
            modifier = Modifier
                .padding(top = 280.dp)
        ) {

            Text(
                text = "MeshWork",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 50.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()

            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Button(
                    onClick = { onClickStudent() },
                    modifier = Modifier
                        .wrapContentSize(),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    shape = RoundedCornerShape(20.dp)
                ) {

                    Text(
                        text = "STUDENT",
                        color = DarkBlueText,
                        fontSize = 26.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                    )

                }

                Button(
                    onClick = { onClickFaculty() },
                    modifier = Modifier
                        .wrapContentSize(),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    shape = RoundedCornerShape(20.dp)
                ) {

                    Text(
                        text = "FACULTY",
                        color = DarkBlueText,
                        fontSize = 26.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                    )

                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserSelectionComposablePreview() {

    UserSelectionComposable(
        navController = NavHostController(LocalContext.current),
        onClickFaculty = {},
        onClickStudent = {}
    )

}

