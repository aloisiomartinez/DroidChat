package com.example.droidchat.navigation.extension

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.navigation.NavBackStackEntry

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideInTo(
    diretion: AnimatedContentTransitionScope.SlideDirection
): EnterTransition {
    return this.slideIntoContainer(
        towards = diretion,
        animationSpec = tween(durationMillis = 300)
    )
}

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideOutTo(
    diretion: AnimatedContentTransitionScope.SlideDirection
): ExitTransition {
    return this.slideOutOfContainer(
        towards = diretion,
        animationSpec = tween(durationMillis = 300)
    )
}