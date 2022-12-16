package com.example.meshworkapp.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.meshworkapp.composables.ClassCardComposable
import com.example.meshworkapp.R
import com.example.meshworkapp.UserInfoDataClass
import com.example.meshworkapp.common.OrganizationNameAndLogoComposable
import com.example.meshworkapp.common.UserInfoCard
import com.example.meshworkapp.composables.GradientBackGround
import com.example.meshworkapp.dataclassfiles.AssignedClassDataClass
import com.example.meshworkapp.viewmodels.CurrentCourseSharedViewModel
import com.example.meshworkapp.viewmodels.FacultySharedViewModel

@Composable
fun FacultyHomeScreen(
    navHostController: NavHostController,
    assignedClassesList: List<AssignedClassDataClass>,
    facultySharedViewModel: FacultySharedViewModel,
    currentCourseSharedViewModel: CurrentCourseSharedViewModel
) {
    val userInfo = UserInfoDataClass(
        name = facultySharedViewModel.facultyUser?.name!!,
        id = facultySharedViewModel.facultyUser?.id!!,
        profilePhoto = painterResource(id = R.drawable.profile_image_dummy)
    )
    Box {
        GradientBackGround()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp)
            //            .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            OrganizationNameAndLogoComposable(
                name = "Chandigarh University",
                logo = painterResource(id = R.drawable.cu_logo),
                modifier = Modifier.padding(top = 30.dp, bottom = 20.dp, start = 30.dp, end = 30.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            UserInfoCard(userInfo = userInfo,
                modifier = Modifier.padding(start = 30.dp,
                    bottom = 20.dp,
                    end = 30.dp,
                    top = 10.dp))
            Spacer(modifier = Modifier.height(0.dp))
            AssignedClassesComposable(modifier = Modifier.padding(start = 30.dp))
            Spacer(modifier = Modifier.height(0.dp))
            ClassesGridComposable(
                assignedClasses = assignedClassesList,
                navHostController = navHostController,
                facultySharedViewModel = facultySharedViewModel,
                currentCourseSharedViewModel = currentCourseSharedViewModel
            )
        }
    }
}



@Composable
fun AssignedClassesComposable(
    modifier: Modifier = Modifier,
) {
    //Assigned Class text
    Text(
        text = "Assigned Classes",
        fontSize = 22.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier,
        color = Color.White
    )
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ClassesGridComposable(
    assignedClasses: List<AssignedClassDataClass>,
    navHostController: NavHostController,
    facultySharedViewModel: FacultySharedViewModel,
    currentCourseSharedViewModel: CurrentCourseSharedViewModel
){
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(
            start = 20.dp,
            end = 20.dp,
            bottom = 50.dp
        ),
        content = {
            items(items = assignedClasses, itemContent = { assignedClass ->
                ClassCardComposable(
                    className = assignedClass.className,
                    subjectName = assignedClass.subject,
                    modifier = Modifier
                        .size(150.dp),
                    navHostController = navHostController,
                    currentCourseSharedViewModel = currentCourseSharedViewModel
                )
            })
        }
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
//    HomeScreen(
//        assignedClassesList = fetchAssignedCLassesList(),
//        navHostController = NavHostController(LocalContext.current)
//    )
}