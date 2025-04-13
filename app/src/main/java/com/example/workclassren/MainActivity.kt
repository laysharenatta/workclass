package com.example.workclassren

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.workclassren.data.dataBase.AppDataBase
import com.example.workclassren.data.dataBase.dataBaseProvider
import com.example.workclassren.ui.screens.AccountsScreen
import com.example.workclassren.ui.screens.ComponentsScreen
import com.example.workclassren.ui.screens.FavoriteAccountScreen
import com.example.workclassren.ui.screens.HomeScreen
import com.example.workclassren.ui.screens.MainMenuScreen
import com.example.workclassren.ui.screens.TestScreen
import com.example.workclassren.ui.screens.InterfaceScreen
import com.example.workclassren.ui.screens.LoginScreen
import com.example.workclassren.ui.screens.ManageAccountScreen
import com.example.workclassren.ui.theme.WorkClassRenTheme

class MainActivity : ComponentActivity() {

    lateinit var dataBase: AppDataBase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            dataBase = dataBaseProvider.getDataBase(this)
            Log.d("debug-db","DataBase loaded successfully")
        }catch (exception:Exception){
            Log.d("debug-db","ERROR: $exception")
        }


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
        composable("login_screen"){ LoginScreen(navController) }
        composable("accounts_screen") { AccountsScreen(navController) }
        composable("manage_account_screen") { ManageAccountScreen(navController) }
        composable("favoriteaccount_screen"){ FavoriteAccountScreen(navController) }

    }

}}

