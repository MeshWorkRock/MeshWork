package com.example.meshworkapp

sealed class Screen(val route : String){
    object UserSelectionScreen : Screen("userSelection_screen")
    object LoginScreenStudent : Screen("login_screen_student")
    object LoginScreenFaculty : Screen("login_screen_faculty")
}
