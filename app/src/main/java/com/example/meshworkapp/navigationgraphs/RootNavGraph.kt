package com.example.meshworkapp.navigationgraphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.meshworkapp.screens.HubScreen

@Composable
fun RootNavGraph(
    navHostController: NavHostController
){
    NavHost(
        navController = navHostController,
        route = TopLevelGraph.rootGraph,
        startDestination = TopLevelGraph.authenticationGraph
    ){
        authNavGraph(navHostController = navHostController)
        composable(route = TopLevelGraph.hubGraph){
            HubScreen()
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