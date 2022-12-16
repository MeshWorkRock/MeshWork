package com.example.meshworkapp.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.meshworkapp.ui.theme.DarkBlueAnimation
import com.example.meshworkapp.ui.theme.LightBlueAnimation
import androidx.navigation.NavHostController
import com.example.meshworkapp.dataclassfiles.AssignedClassDataClass
import com.example.meshworkapp.navigationgraphs.FacultyHubNavigationScreens
import com.example.meshworkapp.ui.theme.DarkBlueText
import com.example.meshworkapp.viewmodels.CurrentCourseSharedViewModel

@Composable
fun ClassCardComposable(
    className: String,
    subjectName: String,
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    currentCourseSharedViewModel: CurrentCourseSharedViewModel
) {
    Card(
        modifier = Modifier
            .padding(5.dp)
            .clickable {
                currentCourseSharedViewModel.addCurrentCourse(AssignedClassDataClass(
                    className = className,
                    subject = subjectName,
                    studentsList = null
                ))
                navHostController.navigate(FacultyHubNavigationScreens.StudentsList.route)
            },
        elevation = 10.dp,
        shape = RoundedCornerShape(20.dp),
    ) {
        Column(
//            verticalArrangement = Arrangement.SpaceBetween,
//            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp)
        ) {

            Text(
                text = subjectName,
                color = DarkBlueText,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(bottom = 5.dp, top = 10.dp)
                    .fillMaxWidth()
            )
            Text(
                text = className,
                color = DarkBlueText    ,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ClassCardPreview() {
//    ClassCardComposable(
//        className = "22MCD-1",
//        subjectName = "Digital Electronics and computing",
//        modifier = Modifier.size(180.dp),
//        navHostController = NavHostController(LocalContext.current)
//    )
}