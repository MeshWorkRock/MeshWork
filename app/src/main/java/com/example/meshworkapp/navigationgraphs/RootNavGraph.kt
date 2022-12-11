package com.example.meshworkapp.navigationgraphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.meshworkapp.screens.HomeScreen
import com.example.meshworkapp.screens.HubScreen

@Composable
fun RootNavGraph(
    navHostController: NavHostController
){
    NavHost(
        navController = navHostController,
        route = TopLevelNavGraph.rootGraph,
        startDestination = TopLevelNavGraph.hubGraph
    ){
        authNavGraph(navHostController = navHostController)
        composable(route = TopLevelNavGraph.hubGraph){
            HubScreen(navHostController)
        }
    }
}

object TopLevelNavGraph{
    const val rootGraph = "root_graph"
    const val authenticationGraph = "authentication_graph"
    const val hubGraph = "home_graph"
    const val chatsGraph = "chats_graph"
    const val announcementGraph = "announcements_graph"
}