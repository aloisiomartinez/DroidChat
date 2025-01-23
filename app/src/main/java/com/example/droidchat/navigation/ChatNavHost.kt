package com.example.droidchat.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.droidchat.ui.feature.splash.SplashRoute
import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable
import kotlin.math.sign

@Serializable
object SplashRoute

@Serializable
object SignInRoute

@Serializable
object SignUpRoute

@Composable
fun ChatNavHost() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = SplashRoute) {
        composable<SplashRoute> {
            SplashRoute()

        }
        composable<SignInRoute>() {

        }
        composable<SignUpRoute> {}
    }
}