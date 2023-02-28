package com.agprastyo.todocompose.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agprastyo.todocompose.data.models.ToDoTask
import com.agprastyo.todocompose.data.repositories.ToDoRepository
import com.agprastyo.todocompose.utils.RequestState
import com.agprastyo.todocompose.utils.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: ToDoRepository
): ViewModel() {

    val searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)
    val searchTextState: MutableState<String> = mutableStateOf("")

    private val _allTask =
        MutableStateFlow<RequestState<List<ToDoTask>>>(RequestState.Idle)
    val allTask: StateFlow<RequestState<List<ToDoTask>>> = _allTask

    fun getAllTask() {
        _allTask.value = RequestState.Loading
        try {
            viewModelScope.launch {
            repository.getAllTask.collect {
                _allTask.value = RequestState.Success(it)
            }
        }
        } catch(e: Exception) {
            _allTask.value = RequestState.Error(e)
        }


    }
}