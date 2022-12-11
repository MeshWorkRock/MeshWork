package com.example.meshworkapp.navigationgraphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.meshworkapp.screens.LoginScreenFacultyComposable
import com.example.meshworkapp.UserSelectionComposable


fun NavGraphBuilder.authNavGraph(
    navHostController: NavHostController
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
            LoginScreenFacultyComposable(
                name = "Faculty",
                onSubmit = {
                    navHostController.navigate(TopLevelGraph.hubGraph)
                }
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