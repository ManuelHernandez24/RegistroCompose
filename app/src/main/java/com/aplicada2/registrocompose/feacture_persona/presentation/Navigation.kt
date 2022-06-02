package com.aplicada2.registrocompose.feacture_persona.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aplicada2.registrocompose.feacture_persona.presentation.home.HomeScreen

@Composable
fun Navigation(){

    val navController = rememberNavController()

    NavHost(
        navController =  navController,
    startDestination = Screen.Home.route
    ){
        composable(route = Screen.Home.route){
            HomeScreen(navController = navController)
        }
    }
}