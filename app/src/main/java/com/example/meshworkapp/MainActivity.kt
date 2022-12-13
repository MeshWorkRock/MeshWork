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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState   )
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