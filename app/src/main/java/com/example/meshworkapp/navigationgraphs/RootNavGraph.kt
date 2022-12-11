package com.example.meshworkapp.navigationgraphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.meshworkapp.screens.HomeScreen

@Composable
fun RootNavGraph(
    navHostController: NavHostController
){
    NavHost(
        navController = navHostController,
        route = TopLevelNavGraph.rootGraph,
        startDestination =TopLevelNavGraph.homeGraph
    ){
        authNavGraph(navHostController = navHostController)
        composable(route = TopLevelNavGraph.homeGraph){
            HomeScreen()
        }
    }
}

object TopLevelNavGraph{
    const val rootGraph = "root_graph"
    const val authenticationGraph = "authentication_graph"
    const val homeGraph = "home_graph"
    const val chatsGraph = "chats_graph"
    const val announcementGraph = "announcements_graph"
}