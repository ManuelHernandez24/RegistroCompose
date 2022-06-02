package com.aplicada2.registrocompose.feacture_persona.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aplicada2.registrocompose.feacture_persona.domain.use_cases.DeletePersona
import com.aplicada2.registrocompose.feacture_persona.domain.use_cases.GetAllPersona
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val deletePersona: DeletePersona,
    getAllPersona: GetAllPersona
): ViewModel() {

    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    init {
        getAllPersona().onEach { personas ->
        _state.value = state.value.copy(
            personas = personas
        )
        }.launchIn(viewModelScope)
    }

    fun onEvent(event: HomeEvent){
        when (event){
            is HomeEvent.DeletePersona -> {
                viewModelScope.launch {
                    deletePersona(event.persona)
                }
            }
        }
    }

}