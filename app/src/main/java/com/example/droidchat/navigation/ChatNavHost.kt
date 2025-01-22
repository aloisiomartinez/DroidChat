package com.example.droidchat.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

const val SPLASH_ROUTE = "splash"
const val SIGN_IN_ROUTE = "signIn"
const val SIGN_UP_ROUTE = "signUp"

@Composable
fun ChatNavHost() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = SPLASH_ROUTE) {
        composable(SPLASH_ROUTE) {
            Text(
                text = "Hello world!",
                color = Color.Black,
                fontSize = 32.sp
            )
        }
        composable(SIGN_IN_ROUTE) {

        }
        composable(SIGN_UP_ROUTE) {}
    }
}