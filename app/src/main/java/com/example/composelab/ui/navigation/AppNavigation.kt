package com.example.composelab.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composelab.R
import com.example.composelab.ui.screens.BankScreen
import com.example.composelab.ui.screens.InsuranceScreen
import com.example.composelab.ui.screens.MainScreen
import com.example.composelab.ui.screens.ScreenTimeScreen
import com.example.composelab.ui.screens.TrackParcelScreen

enum class ComposeNavigation(@StringRes val title:Int){
    Main(title = R.string.app_name),
    Bank(title = R.string.bankingUI),
    ScreenTime(title =R.string.screenTime),
    Insurance(title = R.string.insurance),
    TrackParcel(title = R.string.track)
}

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
){
    Scaffold{innerPadding->
        NavHost(
           navController = navController,
            startDestination = ComposeNavigation.Main.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = ComposeNavigation.Main.name){
                val menuScreens = ComposeNavigation.entries.filter { it != ComposeNavigation.Main }
                MainScreen(
                    screens = menuScreens,
                    onButtonClick = {route ->
                        navController.navigate(route)
                    }
                )
            }
            composable(route = ComposeNavigation.Bank.name){
                BankScreen()
            }
            composable(route = ComposeNavigation.ScreenTime.name){
                ScreenTimeScreen()
            }
            composable(route = ComposeNavigation.Insurance.name){
                InsuranceScreen()
            }
            composable(route = ComposeNavigation.TrackParcel.name){
                TrackParcelScreen()
            }
        }
    }
}