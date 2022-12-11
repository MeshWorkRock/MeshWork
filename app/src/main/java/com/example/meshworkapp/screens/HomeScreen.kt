package com.example.meshworkapp.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meshworkapp.AssignedClassDataClass
import com.example.meshworkapp.ClassCardComposable
import com.example.meshworkapp.R
import com.example.meshworkapp.UserInfoDataClass

    @Composable
fun HomeScreen() {
    val userInfo = UserInfoDataClass(
        name = "John Doe",
        id = "E23422",
        profilePhoto = painterResource(id = R.drawable.profile_image_dummy)
    )
    val assignedClassesList = listOf(
        AssignedClassDataClass("22BSC-1", "Digital Electronics"),
        AssignedClassDataClass("22BSC-1", "Digital Electronics"),
        AssignedClassDataClass("22BSC-1", "Digital Electronics"),
        AssignedClassDataClass("22BSC-1", "Digital Electronics"),
        AssignedClassDataClass("22BSC-1", "Digital Electronics")
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
//            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        OrganizationNameAndLogoComposable(
            name = "Chandigarh University",
            logo = painterResource(id = R.drawable.cu_logo),
            modifier = Modifier.padding(20.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        UserInfoCard(userInfo = userInfo, modifier = Modifier.padding(20.dp))
        Spacer(modifier = Modifier.height(0.dp))
        AssignedClassesComposable()
        Spacer(modifier = Modifier.height(0.dp))
        ClassesGridComposable(assignedClasses = assignedClassesList)
    }
}

@Composable
fun OrganizationNameAndLogoComposable(
    name: String,
    logo: Painter? = null,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        if (logo != null)
            Image(
                painter = logo,
                contentDescription = "Logo",
                modifier = Modifier.size(120.dp)
            )
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun AssignedClassesComposable(
    modifier: Modifier = Modifier,
){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        backgroundColor = Color.Gray,
        elevation = 8.dp
    ) {
       Row(
           verticalAlignment = Alignment.CenterVertically,
           horizontalArrangement = Arrangement.Start,
           modifier = modifier
               .fillMaxWidth()
       ) {
           Image(
               painter = painterResource(id = R.drawable.teacher_teaching),
               contentDescription = null,
               modifier = Modifier
                   .size(80.dp)
                   .padding(8.dp)
           )
           Spacer(modifier = Modifier.width(10.dp))
           Text(
               text = "Assigned Classes",
               fontSize = 24.sp,
               fontWeight = FontWeight.SemiBold
           )
       } 
    }
}

@Composable
fun UserInfoCard(
    userInfo: UserInfoDataClass,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        backgroundColor = Color.LightGray,
        elevation = 8.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = userInfo.profilePhoto,
                contentDescription = "Profile Image",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(80.dp)
                    .padding(6.dp)
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = userInfo.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = userInfo.id,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ClassesGridComposable(
    assignedClasses: List<AssignedClassDataClass>,
){
    LazyVerticalGrid(
        cells = GridCells.Adaptive( 150.dp),
        content = {
            items(items = assignedClasses, itemContent = { assignedClass ->
                ClassCardComposable(
                    className = assignedClass.className,
                    subjectName = assignedClass.subject,
                    modifier = Modifier.size(150.dp)
                )
            })
        }
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}