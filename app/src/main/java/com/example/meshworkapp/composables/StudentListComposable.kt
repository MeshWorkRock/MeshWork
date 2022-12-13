package com.example.meshworkapp.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
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
import com.example.meshworkapp.ChatListDataClass
import com.example.meshworkapp.StudentViewModel
import com.example.meshworkapp.StudentsDataClass

// It will show list of students
@Composable
fun StudentListComposable(
    searchViewModel: StudentViewModel,
    studentDataList: List<StudentsDataClass>
//    onClick: () -> Unit
) {

    var initializedStudentList by remember {
        mutableStateOf(false)
    }
    if(!initializedStudentList){
        searchViewModel.loadStudents(studentDataList)
        initializedStudentList = true
    }

    var studentList = searchViewModel.liveStudentsList.observeAsState().value
    studentList = studentList?.distinct()
//    Toast.makeText(LocalContext.current, "list count = ${studentList?.size}", Toast.LENGTH_SHORT).show()
    LazyColumn(
        modifier = Modifier.padding(bottom = 48.dp)
    ) {
        if (!studentList.isNullOrEmpty()) {
            items(items = studentList) { student ->                            //TODO Optimise By using Other than List.distinct()
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
    Card(modifier = Modifier
        .padding(10.dp),
//        .clickable{ onClick() },
        elevation = 8.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            StudentProfileImageComposable(student)
            StudentNameAndUIDComposable(student)
            if (studentDesignationBadge != null)
                StudentDesignationBadgeComposable(
                    student = student,
                    studentDesignationBadge = studentDesignationBadge
                )
        }
    }
}

// It show student designation in student list
@Composable
fun StudentDesignationBadgeComposable(student : StudentsDataClass, studentDesignationBadge: String) {
    if (student.studentDesignation == studentDesignationBadge) {
        Box(
            modifier = Modifier
                .padding(4.dp)
                .clip(shape = CircleShape)
                .size(50.dp)
                .background(color = Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = studentDesignationBadge,
                color = Black,
                textAlign = TextAlign.Center
            )
        }
    }
}

// It will show student Name and Student UID in student list
@Composable
fun StudentNameAndUIDComposable(student: StudentsDataClass) {
    Column {
        Text(
            text = student.studentName,
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 5.dp)
                .wrapContentWidth(Alignment.Start)
        )
        Text(
            text = student.studentUID,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 5.dp)
                .wrapContentWidth(Alignment.Start)
        )
    }
}

// It will show Student Profile Picture in student list
@Composable
fun StudentProfileImageComposable(student : StudentsDataClass) {
    Image(
        painter = painterResource(id = student.studentProfile),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(5.dp)
            .size(60.dp)
            .clip(CircleShape)
    )
}


