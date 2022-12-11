package com.example.meshworkapp.navigationgraphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.meshworkapp.StudentsDataClass
import com.example.meshworkapp.screens.StudentListScreen

fun NavGraphBuilder.studentListNavGraph(
    navHostController: NavHostController,
    studentsList: List<StudentsDataClass>
){
    navigation(
        route = TopLevelGraph.studentListGraph,
        startDestination = ChatScreensGraph.StudentsListScreen.route
    ){
        composable(route = ChatScreensGraph.StudentsListScreen.route){
//            StudentListScreen() {
//                navHostController.navigate(ChatScreensGraph.ChatScreen.route)
//            }
        }
    }
}

sealed class ChatScreensGraph(
    val route: String
){
    object StudentsListScreen: ChatScreensGraph("students_list_Screen")
    object ChatScreen: ChatScreensGraph("user_list_Screen")
}