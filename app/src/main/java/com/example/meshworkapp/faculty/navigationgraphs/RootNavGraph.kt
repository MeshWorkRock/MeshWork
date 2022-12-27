package com.example.meshworkapp.faculty.navigationgraphs

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.meshworkapp.faculty.screens.FacultyHubScreen
import com.example.meshworkapp.student.viewmodels.StudentSharedViewModel
import com.example.meshworkapp.student.screens.StudentHubScreen
import com.example.meshworkapp.faculty.screens.viewmodels.FacultySharedViewModel

@Composable
fun RootNavGraph(
    navHostController: NavHostController
){

    val facultySharedViewModel: FacultySharedViewModel = viewModel()
    val studentSharedViewModel: StudentSharedViewModel = viewModel()

    NavHost(
        navController = navHostController,
        route = TopLevelGraph.rootGraph,
        startDestination = TopLevelGraph.authenticationGraph
    ){
        authNavGraph(
            navHostController = navHostController,
            facultySharedViewModel = facultySharedViewModel,
            studentSharedViewModel = studentSharedViewModel
        )
        composable(route = TopLevelGraph.facultyHubGraph){
            FacultyHubScreen(facultySharedViewModel = facultySharedViewModel)
        }
        composable(route = TopLevelGraph.studentHubGraph){
            StudentHubScreen(studentSharedViewModel = studentSharedViewModel)
        }
    }
}

object TopLevelGraph{
    const val rootGraph = "root_graph"
    const val authenticationGraph = "authentication_graph"
    const val facultyHubGraph = "faculty_gub_graph"
    const val studentHubGraph = "student_hub_graph"
}