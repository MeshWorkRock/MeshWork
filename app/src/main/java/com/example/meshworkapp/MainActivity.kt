package com.example.meshworkapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.meshworkapp.composables.TopBarComposable
import com.example.meshworkapp.navigationgraphs.RootNavGraph
import com.example.meshworkapp.screens.HomeScreen
import com.example.meshworkapp.ui.theme.MeshWorkAppTheme
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : ComponentActivity() {
    lateinit var fbFirestore: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fbFirestore = FirebaseFirestore.getInstance()
        val city = hashMapOf(
            "name" to "Los Angeles",
            "state" to "CA",
            "country" to "USA"
        )
        fbFirestore.collection("TestCOll").document("TestDoc").set(city)
        setContent {
            MeshWorkAppTheme {
//                TopBarComposable()
                RootNavGraph(navHostController = rememberNavController())
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MeshWorkAppTheme {
//        TopBarComposable()
//        HomeScreen()
////        DummyMainScreen()
//    }
//}