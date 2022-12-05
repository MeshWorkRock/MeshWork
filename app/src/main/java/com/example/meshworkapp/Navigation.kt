package com.example.meshworkapp

import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.meshworkapp.ui.theme.UserSelection


@Composable
fun Navigation(){
    val studentLogin : String = "Student"
    val facultyLogin : String = "Faculty"

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.UserSelectionScreen.route){
        composable(route = Screen.UserSelectionScreen.route){
            UserSelection(navController = navController)
        }
        composable(route = Screen.LoginScreenStudent.route){
            LoginScreenStudent(studentLogin)
        }
        composable(route = Screen.LoginScreenFaculty.route){
            LoginScreenFaculty(facultyLogin)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CallFunction(){
    Navigation()
}