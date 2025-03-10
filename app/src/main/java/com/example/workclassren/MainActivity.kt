package com.example.workclassren

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.workclassren.ui.screens.ComponentsScreen
import com.example.workclassren.ui.screens.HomeScreen
import com.example.workclassren.ui.screens.MainMenuScreen
import com.example.workclassren.ui.screens.TestScreen
import com.example.workclassren.ui.screens.InterfaceScreen
import com.example.workclassren.ui.theme.WorkClassRenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         //enableEdgeToEdge()
        setContent {
            WorkClassRenTheme {
                ComposeMultiScreenApp()


            }
        }
    }


@Composable
fun ComposeMultiScreenApp(){
    val navController = rememberNavController()
SetupNavGraph(navController = navController)
}

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "main_menu") {
        composable("main_menu"){ MainMenuScreen(navController)}
        composable ("home_screen"){ HomeScreen(navController)}
        composable("test_screen"){ TestScreen(navController)}

        composable("components_screen"){ ComponentsScreen(navController) }

        composable("interface_screen"){ InterfaceScreen(navController)}

    }

}}

