package com.example.meshworkapp.navigationgraphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.meshworkapp.screens.LoginScreen
import com.example.meshworkapp.UserSelectionComposable
import com.example.meshworkapp.studentmodule.StudentSharedViewModel
import com.example.meshworkapp.viewmodels.FacultySharedViewModel

fun NavGraphBuilder.authNavGraph(
    navHostController: NavHostController,
    facultySharedViewModel: FacultySharedViewModel,
    studentSharedViewModel: StudentSharedViewModel
) {

    navigation(
        route = TopLevelGraph.authenticationGraph,
        startDestination = AuthScreensGraph.UserSelect.route
    ) {
        composable(route = AuthScreensGraph.UserSelect.route) {
            UserSelectionComposable(
                navController = navHostController,
                onClickFaculty = {
                    navHostController.navigate(AuthScreensGraph.LoginFaculty.route)
                },
                onClickStudent = {
                    navHostController.navigate(AuthScreensGraph.LoginStudent.route)
                }
            )
        }
        composable(route = AuthScreensGraph.LoginFaculty.route){
            LoginScreen(
                user = "faculty",
                onSubmit = {
                    navHostController.navigate(TopLevelGraph.facultyHubGraph)
                },
                facultySharedViewModel = facultySharedViewModel,
                studentSharedViewModel = studentSharedViewModel
            )
        }
        composable(route = AuthScreensGraph.LoginStudent.route){
            LoginScreen(
                user = "students",
                onSubmit = {
                    navHostController.navigate(TopLevelGraph.studentHubGraph)
                },
                facultySharedViewModel = facultySharedViewModel,
                studentSharedViewModel = studentSharedViewModel
            )
        }
    }
}

sealed class AuthScreensGraph(
    val route: String
) {
    object UserSelect: AuthScreensGraph("user_select")
    object LoginFaculty    : AuthScreensGraph("login_faculty")
    object LoginStudent    : AuthScreensGraph("login_student")
}