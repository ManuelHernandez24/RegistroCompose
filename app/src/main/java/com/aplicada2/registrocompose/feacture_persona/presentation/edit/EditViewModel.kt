package com.aplicada2.registrocompose.feacture_persona.presentation.edit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aplicada2.registrocompose.feacture_persona.domain.model.Persona
import com.aplicada2.registrocompose.feacture_persona.domain.use_cases.GetPersona
import com.aplicada2.registrocompose.feacture_persona.domain.use_cases.InsertPersona
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
    private val getPersona: GetPersona,
    private val insertPersona: InsertPersona,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _personaNombres = mutableStateOf(TextFieldState())
    val personaNombres: State<TextFieldState> = _personaNombres

    private val _personaEmail= mutableStateOf(TextFieldState())
    val personaEmail: State<TextFieldState> = _personaEmail

    private val _personaOcupacionId = mutableStateOf(TextFieldState())
    val personaOcupacionId: State<TextFieldState> = _personaOcupacionId

    private val _personaBalance = mutableStateOf(TextFieldState())
    val personaBalance: State<TextFieldState> = _personaBalance

    private var currentPersonaId: Int? = null

    init{
        savedStateHandle.get<Int>("personaId")?.let { personaId ->
            if(personaId != -1){
                viewModelScope.launch {
                    getPersona(personaId)?.also { persona ->
                        currentPersonaId = persona.PersonaId
                        _personaNombres.value = personaNombres.value.copy(
                            text = persona.Nombres
                        )

                        _personaEmail.value = personaEmail.value.copy(
                            text = persona.Email
                        )

                        _personaOcupacionId.value = personaOcupacionId.value.copy(
                            text = persona.OcupacionId.toString()
                        )

                        _personaBalance.value = personaBalance.value.copy(
                            text = persona.Balance.toString()
                        )
                    }
                }
            }
        }
    }

    fun onEvent(event: EditEvent){
        when(event){
            is EditEvent.EnteredNombres ->{
                _personaNombres.value = personaNombres.value.copy(
                    text = event.value
                )
            }

            is EditEvent.EnteredEmail ->{
                _personaEmail.value = personaEmail.value.copy(
                    text = event.value
                )
            }

            is EditEvent.EnteredOcupacionId ->{
                _personaOcupacionId.value = personaOcupacionId.value.copy(
                    text = event.value
                )
            }

            is EditEvent.EnteredBalance ->{
                _personaBalance.value = personaBalance.value.copy(
                    text = event.value
                )
            }

            EditEvent.InsertPersona ->{
                viewModelScope.launch {
                    insertPersona(
                        Persona(
                            Nombres = personaNombres.value.text,
                            Email = personaEmail.value.text,
                            OcupacionId = personaOcupacionId.value.text.toInt(),
                            Balance = personaBalance.value.text.toDouble(),
                            PersonaId = currentPersonaId
                        )
                    )
                }
            }
        }
    }
}