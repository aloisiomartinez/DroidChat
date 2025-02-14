package com.example.droidchat.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import androidx.navigation.toRoute
import com.example.droidchat.navigation.extension.slideInTo
import com.example.droidchat.navigation.extension.slideOutTo
import com.example.droidchat.ui.feature.signin.SignInRoute
import com.example.droidchat.ui.feature.signin.SignInScreen
import com.example.droidchat.ui.feature.signup.SignUpRoute
import com.example.droidchat.ui.feature.splash.SplashRoute
import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable
import kotlin.math.sign


sealed interface Route {
    @Serializable
    object SplashRoute

    @Serializable
    object SignInRoute

    @Serializable
    object SignUpRoute
}


@Composable
fun ChatNavHost() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = Route.SplashRoute) {
        composable<Route.SplashRoute> {
            SplashRoute(
                onNavigateToSignIn = {
                    navController.navigate(
                        route = Route.SignInRoute,
                        navOptions = navOptions {
                            popUpTo(Route.SplashRoute) {
                                inclusive = true
                            }
                        }
                    )
                }
            )
        }

        composable<Route.SignInRoute>(
            enterTransition = {
                this.slideInTo(AnimatedContentTransitionScope.SlideDirection.Right)
            },
            exitTransition = {
                this.slideOutTo(AnimatedContentTransitionScope.SlideDirection.Left)
            }
        ) {
            SignInRoute(
                navigateToSignUp = {
                    navController.navigate(Route.SignUpRoute)
                }
            )
        }

        composable<Route.SignUpRoute>(
            enterTransition = {
                this.slideInTo(AnimatedContentTransitionScope.SlideDirection.Left)

            },
            exitTransition = {
                this.slideOutTo(AnimatedContentTransitionScope.SlideDirection.Right)
            }
        ) {
            SignUpRoute(

            )
        }
    }
}