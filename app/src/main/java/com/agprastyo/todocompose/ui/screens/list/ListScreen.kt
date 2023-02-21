package com.agprastyo.todocompose.ui.screens.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.agprastyo.todocompose.R
import com.agprastyo.todocompose.ui.theme.fabBackgroundColor
import com.agprastyo.todocompose.ui.viewmodel.SharedViewModel
import com.agprastyo.todocompose.utils.SearchAppBarState

@Composable
fun ListScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    LaunchedEffect(key1 = true) {
        sharedViewModel.getAllTask()
    }

    val allTasks by sharedViewModel.allTask.collectAsState()

    val searchAppBarState: SearchAppBarState
            by sharedViewModel.searchAppBarState
    val searchTextState: String by sharedViewModel.searchTextState

    Scaffold(
        topBar = {
            ListAppBar(
                sharedViewModel = sharedViewModel,
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState
            )
        },
        content = {
            ListContent(
                tasks = allTasks,
                navigateToTaskScreen = navigateToTaskScreen
            )
        },
        floatingActionButton = {
            ListFab(
                onFabClicked = navigateToTaskScreen
            )
        }
    )
}

@Composable
fun ListFab(
    onFabClicked: (taskId: Int) -> Unit
) {
    FloatingActionButton(
        onClick = {
            onFabClicked(-1)
        },
        backgroundColor = MaterialTheme.colors.fabBackgroundColor,
        modifier = Modifier
            .padding(
                end = 16.dp,
                bottom = 16.dp
            )
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(
                R.string.addButton
            ),
            tint = Color.White
        )
    }
}


