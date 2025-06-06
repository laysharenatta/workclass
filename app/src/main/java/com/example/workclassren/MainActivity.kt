package com.example.workclassren


import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.workclassren.data.dataBase.AppDataBase
import com.example.workclassren.data.dataBase.dataBaseProvider
import com.example.workclassren.ui.screens.AccountScreen
import com.example.workclassren.ui.screens.AppScreen
import com.example.workclassren.ui.screens.BiometricScreen
import com.example.workclassren.ui.screens.CamaraApp
import com.example.workclassren.ui.screens.ComponentsScreen
import com.example.workclassren.ui.screens.FavoriteAccountScreen
import com.example.workclassren.ui.screens.HomeScreen
import com.example.workclassren.ui.screens.MainMenuScreen
import com.example.workclassren.ui.screens.TestScreen
import com.example.workclassren.ui.screens.InterfaceScreen
import com.example.workclassren.ui.screens.LoginScreen
import com.example.workclassren.ui.screens.ManageAccountScreen
import com.example.workclassren.ui.screens.Notifications


//class MainActivity : ComponentActivity() {
class MainActivity : FragmentActivity() {
    lateinit var database:AppDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try{
            database = dataBaseProvider.getDataBase(this)
            Log.d("debug-db","Database loaded succesfully")
        }catch(exception:Exception){
            Log.d("debug-db","Error: $exception")
        }
        enableEdgeToEdge()
        setContent {

                ComposeMultiScreenApp()


        }
    }
}
//CLOSE CLASS

@Composable
fun ComposeMultiScreenApp() { //La navegacion entre pantallas
    val navController = rememberNavController()
    SetupNavGraph(navController = navController)
}

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "main_menu") {
        composable("main_menu"){ MainMenuScreen(navController)}
        composable("home_screen"){ HomeScreen(navController)}
        composable("test_screen"){ TestScreen(navController)}
        composable("components_screen"){ ComponentsScreen(navController) }
        composable("interface_screen"){ InterfaceScreen(navController)}
        composable("login_screen"){ LoginScreen(navController) }
        composable("accounts_screen") { AccountScreen(navController) }
        composable("camara_screen") { CamaraApp(navController) }

       composable("app_screen") { AppScreen(navController) }

        composable("manage_account_screen?id={id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            ManageAccountScreen(navController = navController, id = id)
        }

        composable("favorite_accounts_screen") { FavoriteAccountScreen(navController) }

        composable("biometric_screen") {
            val context = LocalContext.current
            BiometricScreen(navController, onAuthSuccess = {
                Toast.makeText(context, "¡Autenticación exitosa!", Toast.LENGTH_SHORT).show()
            })
        }

        //composable(
        // route = "notifications_screen",
        //deepLinks = listOf(navDeepLink { uriPattern = "app://notificacion"
        // })
        //) {
        //Notifications(navController)
        //}
        composable("notifications_screen") { Notifications(navController) }


    }
}



