package com.example.meshworkapp.navigationgraphs

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.meshworkapp.screens.LoginScreenFacultyComposable
import com.example.meshworkapp.UserSelectionComposable
import com.example.meshworkapp.viewmodels.FacultySharedViewModel

fun NavGraphBuilder.authNavGraph(
    navHostController: NavHostController,
    facultySharedViewModel: FacultySharedViewModel
) {

    navigation(
        route = TopLevelGraph.authenticationGraph,
        startDestination = AuthScreensGraph.UserSelect.route
    ) {
        composable(route = AuthScreensGraph.UserSelect.route) {
            UserSelectionComposable(
                navController = navHostController,
                onClick = {
                    navHostController.navigate(AuthScreensGraph.Login.route)
                }
            )
        }
        composable(route = AuthScreensGraph.Login.route){

            Log.e("Flag", "AuthNavGraph")
            LoginScreenFacultyComposable(
                name = "Faculty",
                onSubmit = {
                    navHostController.navigate(TopLevelGraph.hubGraph)
                },
                facultySharedViewModel = facultySharedViewModel
            )
        }
    }
}

sealed class AuthScreensGraph(
    val route: String
) {
    object UserSelect: AuthScreensGraph("user_select")
    object Login    : AuthScreensGraph("login")
}