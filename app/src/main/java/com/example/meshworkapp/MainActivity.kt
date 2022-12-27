package com.example.meshworkapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.meshworkapp.faculty.navigationgraphs.RootNavGraph
import com.example.meshworkapp.ui.theme.MeshWorkAppTheme
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : ComponentActivity() {

    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeshWorkAppTheme {
//                TopBarComposable()
                RootNavGraph(navHostController = rememberNavController())
            }
        }

    }
}


