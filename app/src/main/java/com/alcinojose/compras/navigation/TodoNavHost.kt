package com.alcinojose.compras.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.alcinojose.compras.ui.feature.AddEditScreen
import com.alcinojose.compras.ui.feature.ListScreen
import kotlinx.serialization.Serializable

@Serializable
object ListRoute

@Serializable
data class AddEditRoute(val id: Long? = null)

@Composable
fun TodoNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ListRoute)  {
        composable<ListRoute> {
            ListScreen(
                navigateToAddEditScreen = {id ->
                    navController.navigate(AddEditRoute(id = id))
                }
            )
        }
        composable<AddEditRoute> { backStackEntry ->
            val addEditRoute = backStackEntry.toRoute<AddEditRoute>()
            AddEditScreen()
        }

    }

}