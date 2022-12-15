package com.example.meshworkapp.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavHostController
import com.example.meshworkapp.dataclassfiles.ListItemDataClass
import com.example.meshworkapp.navigationgraphs.HubNavigationScreens
import kotlinx.coroutines.launch


@Composable
fun AnnouncementFilterScreenComposable(navHostController: NavHostController) {

    val batchList = listOf("2022", "2021", "2020", "2019")
    val courseList = listOf("BCA", "MCA", "BSC")
    val sectionlist = listOf("1", "2", "3", "4", "5", "6", "7")
    val grouplist = listOf("A", "B")

    var updatedBatchList = listOf<ListItemDataClass>()
    val updatedCourseList = listOf("BCA", "MCA", "BSC")
    val updatedSectionlist = listOf("1", "2", "3", "4", "5", "6", "7")
    val updatedGrouplist = listOf("A", "B")

    Box {
        CreateAnnouncementBackground()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp)
        ) {

            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    text = "Create ",
                    fontSize = 30.sp,
                    modifier = Modifier.padding(top = 35.dp, start = 10.dp),
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )
                Text(
                    text = "Announcement",
                    fontSize = 30.sp,
                    modifier = Modifier.padding(bottom = 20.dp, start = 10.dp),
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )
            }
            BatchFilterOption(batchList)
            CourseFilterOption()
            SectionFilterOption()
            GroupFilterOption()


            Spacer(modifier = Modifier.height(20.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 20.dp)
                    .fillMaxWidth()
            ) {
                Button(onClick = {
                    navHostController.popBackStack()
                    Modifier.background(Color.White)
                },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    shape = RoundedCornerShape(20.dp)) {
                    Text(
                        text = "Cancel",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .height(30.dp)
                            .width(100.dp),
                        color = Color.Black
                    )
                }

                Button(onClick = {
                    navigateToCreateAnnouncementScreen(navHostController)
                },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    shape = RoundedCornerShape(20.dp)) {
                    Text(
                        text = "Create", fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .height(30.dp)
                            .width(100.dp),
                        color = Color.Black
                    )
                }
            }


//            AnnouncementFilterBottomScreenComposable(batchList = batchList)
//            AnnouncementFilterBottomScreenComposable(batchList = courseList)
//            AnnouncementFilterBottomScreenComposable(batchList = sectionlist)
//            AnnouncementFilterBottomScreenComposable(batchList = grouplist)


        }
    }
}

@Composable
fun BatchFilterOption(batchList: List<String>) {
    Card(
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Color.White,
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .clickable(onClick = {
//                AnnouncementFilterSelectorScreenComposable(batchList = batchList)
            })
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        )
        {
            Text(
                text = "Batch",
                Modifier.padding(start = 14.dp, top = 10.dp, end = 10.dp, bottom = 10.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
            )
        }
    }
}

//Course Filter
@Composable
fun CourseFilterOption() {
    Card(
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Color.White,
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .clickable(onClick = {}),

        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        )
        {
            Text(
                text = "Course",
                Modifier
                    .padding(start = 14.dp, top = 10.dp, end = 10.dp, bottom = 10.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
            )
        }
    }
}


//Section Filter
@Composable
fun SectionFilterOption() {
    Card(
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Color.White,
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .clickable(onClick = {})
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        )
        {
            Text(
                text = "Section",
                Modifier
                    .padding(start = 14.dp, top = 10.dp, end = 10.dp, bottom = 10.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
            )
        }
    }
}

//Group Filter
@Composable
fun GroupFilterOption() {
    Card(
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Color.White,
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .clickable(onClick = {}),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        )
        {
            Text(
                text = "Group",
                Modifier
                    .padding(start = 14.dp, top = 10.dp, end = 10.dp, bottom = 10.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
            )
        }
    }
}

//Code of Batch Selection Block
@Composable
fun BatchSelectorBlockComposable(batchList: List<String>) {
//
//    var selectedItems = listOf("")
//    var showBottomScreen by remember {
//         mutableStateOf(false)
//     }

}


@Composable
fun CourseSelectorBlockComposable(courseList: List<String>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Course",
            Modifier
                .weight(1f)
                .align(alignment = Alignment.CenterVertically)
                .padding(start = 10.dp),
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold,
        )
        val courseValue = BatchFilterBlockComposable(modifier = Modifier.weight(1f), courseList)
    }
}

@Composable
fun SectionSelectorBlockComposable(sectionlist: List<String>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Section",
            Modifier
                .weight(1f)
                .align(alignment = Alignment.CenterVertically)
                .padding(start = 10.dp),
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold,
        )
        val section = BatchFilterBlockComposable(modifier = Modifier.weight(1f), sectionlist)
    }
}

@Composable
fun GroupSelectorBlockComposable(grouplist: List<String>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Group",
            Modifier
                .weight(1f)
                .align(alignment = Alignment.CenterVertically)
                .padding(start = 10.dp),
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold,
        )
        val group = BatchFilterBlockComposable(modifier = Modifier.weight(1f), grouplist)
    }
}

@Composable
fun BatchFilterBlockComposable(modifier: Modifier, list: List<String>): String {
    // Declaring a boolean value to store
    // the expanded state of the Text Field
    var mExpanded by remember { mutableStateOf(false) }

    // Create a list of cities
    val options = list
    // Create a string value to store the selected city
    var mSelectedText by remember { mutableStateOf("") }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }

    // Up Icon when expanded and down icon when collapsed
    val icon = if (mExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column(modifier = modifier) {

        // Create an Outlined Text Field
        // with icon and not expanded
        OutlinedTextField(
            value = mSelectedText,
            onValueChange = { mSelectedText = it },
            modifier = Modifier
                .onGloballyPositioned { coordinates ->
                    // This value is used to assign to
                    // the DropDown the same width
                    mTextFieldSize = coordinates.size.toSize()
                },
            trailingIcon = {
                Icon(icon, "contentDescription",
                    Modifier.clickable { mExpanded = !mExpanded })
            }
        )

        // Create a drop-down menu with list of cities,
        // when clicked, set the Text Field text as the city selected
        DropdownMenu(
            expanded = mExpanded,
            onDismissRequest = { mExpanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { mTextFieldSize.width.toDp() })
        ) {
            options.forEach { label ->
                DropdownMenuItem(onClick = {
                    mSelectedText = label
                    mExpanded = false
                }) {
                    Text(text = label)
                }
            }
        }
    }

    return mSelectedText
}

fun navigateToCreateAnnouncementScreen(navHostController: NavHostController) {
    navHostController.navigate(HubNavigationScreens.CreatAndPostAnnouncement.route)
}

@Preview(showBackground = true)
@Composable
fun NewAnnouncementPreview() {
    AnnouncementFilterScreenComposable(navHostController = NavHostController(LocalContext.current))
}
