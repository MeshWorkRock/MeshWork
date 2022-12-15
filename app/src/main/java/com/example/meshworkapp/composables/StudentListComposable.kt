package com.example.meshworkapp.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.meshworkapp.ChatListDataClass
import com.example.meshworkapp.StudentViewModel
import com.example.meshworkapp.StudentsDataClass
import com.example.meshworkapp.R
import com.example.meshworkapp.navigationgraphs.ChatScreensGraph
import com.example.meshworkapp.ui.theme.DarkBlueAnimation
import com.example.meshworkapp.ui.theme.DarkBlueText
import com.example.meshworkapp.ui.theme.LightBlueAnimation
import com.example.meshworkapp.ui.theme.LightBlueText
import com.example.meshworkapp.viewmodels.CurrentCourseSharedViewModel

// It will show list of students
@Composable
fun StudentListComposable(
    searchViewModel: StudentViewModel,
    currentCourseSharedViewModel: CurrentCourseSharedViewModel
//    studentDataList: List<StudentsDataClass>
//    onClick: () -> Unit
) {

    var initializedStudentList by remember {
        mutableStateOf(false)
    }
    if(!initializedStudentList && currentCourseSharedViewModel.currentCourse.value?.studentsList != null){
        searchViewModel.loadStudents(currentCourseSharedViewModel.currentCourse.value?.studentsList)
        initializedStudentList = true
    }

    var studentList = searchViewModel.liveStudentsList.observeAsState().value
    studentList = studentList?.distinct()
//    Toast.makeText(LocalContext.current, "list count = ${studentList?.size}", Toast.LENGTH_SHORT).show()
    LazyColumn(
        modifier = Modifier.padding(bottom = 48.dp)
    ) {
        if (!studentList.isNullOrEmpty()) {
            items(items = studentList) { student ->
                val studentDesignationBadge = student.studentDesignation
                StudentListCardComposable(
                    student = student,
                    studentDesignationBadge = studentDesignationBadge
//                    onClick = { onClick }
                )
            }
        }
    }
}

// Card which contains student profile composable,
// student UID composable, student designation badge composable
@Composable
fun StudentListCardComposable(
    student: StudentsDataClass,
    studentDesignationBadge: String?,
//    onClick: () -> Unit
) {
    Card(
        elevation = 8.dp,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(5.dp)
//        .clickable{ onClick() },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row() {
                StudentProfileImageComposable(student)
                StudentNameAndUIDComposable(student)
            }
            Row(
                modifier = Modifier
                    .padding(end = 10.dp)
            ) {
                if (studentDesignationBadge != null)
                    StudentDesignationBadgeComposable(
                        student = student,
                        studentDesignationBadge = studentDesignationBadge
                    )
            }

        }


    }
}

// It show student designation in student list
@Composable
fun StudentDesignationBadgeComposable(student : StudentsDataClass, studentDesignationBadge: String) {
    if (student.studentDesignation == studentDesignationBadge) {

        Icon(
            modifier = Modifier
                .size(30.dp),
            painter = painterResource(id = R.drawable.cr_badge_star),
            contentDescription = "Star Icon",
            tint = LightBlueText
        )

    }
}

// It will show student Name and Student UID in student list
@Composable
fun StudentNameAndUIDComposable(student: StudentsDataClass) {
    Column(
        modifier = Modifier.padding(top = 5.dp)
    ) {
        Text(
            text = student.studentName!!,
            style = MaterialTheme.typography.h6,
            color = DarkBlueText,
            modifier = Modifier
//                .padding(horizontal = 20.dp, vertical = 5.dp)
                .wrapContentWidth(Alignment.Start)
        )
        Text(
            text = student.studentUID!!,
            style = MaterialTheme.typography.body2,
            color = DarkBlueText,
            modifier = Modifier
//                .padding(horizontal = 20.dp, vertical = 5.dp)
                .wrapContentWidth(Alignment.Start)
        )
    }
}

// It will show Student Profile Picture in student list
@Composable
fun StudentProfileImageComposable(student : StudentsDataClass) {
    Image(
        painter = painterResource(id = student.studentProfile!!),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(5.dp)
            .size(50.dp)
            .clip(CircleShape)
    )
}

@Preview(showBackground = true)
@Composable
fun StudentsListScreenPreview(){
    val s = StudentsDataClass(
        studentName = "Pankaj Singh",
        studentUID = "22MCC20049",
        studentProfile = R.drawable.dummy_profile_pic,
        studentDesignation = "CR"
    )
    StudentListCardComposable(student = s, studentDesignationBadge = "CR")
}



