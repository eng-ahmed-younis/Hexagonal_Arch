package com.base.hexagonal_arch.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.base.hexagonal_arch.navigation.AppScreen

fun NavGraphBuilder.mainNavGraph(){
    navigation(
        startDestination = AppScreen.MainGraph.HomeScreen.route,
        route = AppScreen.MainGraph.route
    ){
        composable(AppScreen.MainGraph.HomeScreen.route){

        }

    }
}