package com.example.meshworkapp.navigationgraphs

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.meshworkapp.screens.HubScreen
import com.example.meshworkapp.viewmodels.FacultySharedViewModel

@Composable
fun RootNavGraph(
    navHostController: NavHostController
){

    val facultySharedViewModel: FacultySharedViewModel = viewModel()

    NavHost(
        navController = navHostController,
        route = TopLevelGraph.rootGraph,
        startDestination = TopLevelGraph.authenticationGraph
    ){
        authNavGraph(navHostController = navHostController, facultySharedViewModel = facultySharedViewModel)
        composable(route = TopLevelGraph.hubGraph){
            HubScreen(facultySharedViewModel = facultySharedViewModel)
        }
    }
}

object TopLevelGraph{
    const val rootGraph = "root_graph"
    const val authenticationGraph = "authentication_graph"
    const val hubGraph = "home_graph"
    const val studentListGraph = "student_list_graph"
    const val announcementGraph = "announcements_graph"
}