package com.base.common.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class StateAndEventViewModel<UiState, UiEvent>(initialState: UiState) : ViewModel() {

    private val events = MutableSharedFlow<UiEvent>(replay = 0)

    private val _state = MutableStateFlow(initialState)
    val state = _state.asStateFlow()


    init {
        viewModelScope.launch {
            events.collect {
                handleEvent(it)
            }
        }
    }


    protected abstract fun handleEvent(event: UiEvent)
    // take parameter as extension function from UiState class ......... UiState is data class take extension from it may be copy function
    // return Ui State object
    protected fun updateUiState(update: UiState.() -> UiState) {
        /** update is member function of type UiState this member return UiState object = copy() function of data class
         * */
        _state.update {
            // call value to access member function of data class that named update
            _state.value.update()
        }
    }

    fun onEvent(event: UiEvent){
        viewModelScope.launch {
            events.emit(event)
        }
    }


}