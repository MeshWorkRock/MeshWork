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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavHostController
import com.example.meshworkapp.navigationgraphs.HubNavigationScreens


@Composable
fun AnnouncementFilterScreenComposable(navHostController: NavHostController) {
    val batchList = listOf("2018", "2019", "2020", "2021", "2022")
    val courseList = listOf("BCA", "MCA", "BSC")
    val sectionlist = listOf("1", "2", "3", "4", "5", "6", "7")
    val grouplist = listOf("A", "B")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp)
    ) {

        Column(horizontalAlignment = Alignment.Start) {
            Text(
                text = "Create ",
                fontSize = 30.sp,
                modifier = Modifier.padding(top = 35.dp, start = 10.dp)
            )
            Text(
                text = "Announcement",
                fontSize = 30.sp,
                modifier = Modifier.padding(bottom = 20.dp, start = 10.dp)
            )
        }

        BatchSelectorBlockComposable(batchList)
        CourseSelectorBlockComposable(courseList)
        SectionSelectorBlockComposable(sectionlist)
        GroupSelectorBlockComposable(grouplist)

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 20.dp)
                .fillMaxWidth()
        ) {
            Button(onClick = { navHostController.popBackStack()}, shape = RoundedCornerShape(20.dp)) {
                Text(
                    text = "Cancel",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .height(30.dp)
                        .width(100.dp)
                )
            }

            Button(onClick = { navigateToCreateAnnouncementScreen(navHostController) }, shape = RoundedCornerShape(20.dp)) {
                Text(
                    text = "Create", fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .height(30.dp)
                        .width(100.dp)
                )
            }
        }
    }
}

//Code of Batch Selection Block
@Composable
fun BatchSelectorBlockComposable(batchList: List<String>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.Center
    )
    {
        Text(
            text = "Batch",
            Modifier
                .weight(1f)
                .align(alignment = Alignment.CenterVertically)
                .padding(start = 10.dp),
            fontSize = 30.sp
        )
        BatchFilterBlockComposable(modifier = Modifier.weight(2f), batchList)
    }
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
            fontSize = 30.sp
        )
        BatchFilterBlockComposable(modifier = Modifier.weight(2f), courseList)
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
            fontSize = 30.sp
        )
        BatchFilterBlockComposable(modifier = Modifier.weight(2f), sectionlist)
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
            fontSize = 30.sp
        )
        BatchFilterBlockComposable(modifier = Modifier.weight(2f), grouplist)
    }
}

@Composable
fun BatchFilterBlockComposable(modifier: Modifier, list: List<String>) {
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
                .fillMaxWidth()
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
}

fun navigateToCreateAnnouncementScreen(navHostController: NavHostController){
    navHostController.navigate(HubNavigationScreens.CreatAndPostAnnouncement.route)
}

@Preview(showBackground = true)
@Composable
fun NewAnnouncementPreview() {
    AnnouncementFilterScreenComposable(navHostController = NavHostController(LocalContext.current))
}
