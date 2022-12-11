//package com.example.meshworkapp
//
//import androidx.navigation.compose.rememberNavController
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import com.example.meshworkapp.screens.LoginScreenFacultyComposable
//import com.example.meshworkapp.screens.LoginScreenStudentComposable
//import com.example.meshworkapp.UserSelectionComposable
//
//
//@Composable
//fun NavigationGraphComposable(){
//    val studentLogin : String = "Student"
//    val facultyLogin : String = "Faculty"
//
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = Screen.UserSelectionScreen.route){
//        composable(route = Screen.UserSelectionScreen.route){
//            UserSelectionComposable(navController = navController)
//        }
//        composable(route = Screen.LoginScreenStudent.route){
//            LoginScreenStudentComposable(studentLogin)
//        }
//        composable(route = Screen.LoginScreenFaculty.route){
//            LoginScreenFacultyComposable(facultyLogin)
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun CallFunction(){
//    NavigationGraphComposable()
//}