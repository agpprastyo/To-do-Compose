package com.agprastyo.todocompose.navigation

import androidx.navigation.NavHostController
import com.agprastyo.todocompose.utils.Action
import com.agprastyo.todocompose.utils.Constants.LIST_SCREEN
import com.agprastyo.todocompose.utils.Constants.TASK_SCREEN

class Screens(navController: NavHostController) {

    val list: (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }
    val task: (Int) -> Unit = { taskId ->
        navController.navigate("task/$taskId")
    }
}