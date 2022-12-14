package com.example.meshworkapp.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.meshworkapp.AssignedClassDataClass
import com.example.meshworkapp.composables.ClassCardComposable
import com.example.meshworkapp.R
import com.example.meshworkapp.UserInfoDataClass
import com.example.meshworkapp.composables.GradientBackGround
import com.example.meshworkapp.navigationgraphs.fetchAssignedCLassesList
import com.example.meshworkapp.ui.theme.DarkBlueText
import com.example.meshworkapp.ui.theme.LightBlueAnimation
import com.example.meshworkapp.ui.theme.LightBlueText

@Composable
fun HomeScreen(
        navHostController: NavHostController,
        assignedClassesList: List<AssignedClassDataClass>
) {
    val userInfo = UserInfoDataClass(
        name = "Welcome Rydhm",
        id = "E9875",
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
                navHostController = navHostController
            )
        }
    }
}

@Composable
fun OrganizationNameAndLogoComposable(
    name: String,
    logo: Painter? = null,
    modifier: Modifier
) {
    Row {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = modifier
                .fillMaxWidth()
                .weight(7f)
        ) {

            Text(
                text = "MeshWork",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                textAlign = TextAlign.Start,
                color = Color.White
            )
        }
        Image(
            painter = painterResource(id = R.drawable.settings),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .padding(top = 30.dp, end = 20.dp)
                .weight(1f), alignment = Alignment.TopStart)

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

@Composable
fun UserInfoCard(
    userInfo: UserInfoDataClass,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        backgroundColor =Color.White,
        elevation = 8.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(5.dp)
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
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = userInfo.name,
                        fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = LightBlueText
                )
                Text(
                    text = userInfo.id,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.End,
                    color = LightBlueText
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ClassesGridComposable(
    assignedClasses: List<AssignedClassDataClass>,
    navHostController: NavHostController
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
                    navHostController = navHostController
                )
            })
        }
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        assignedClassesList = fetchAssignedCLassesList(),
        navHostController = NavHostController(LocalContext.current)
    )
}