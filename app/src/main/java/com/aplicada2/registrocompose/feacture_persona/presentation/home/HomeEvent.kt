package com.aplicada2.registrocompose.feacture_persona.presentation.home

import com.aplicada2.registrocompose.feacture_persona.domain.model.Persona

sealed class HomeEvent {
    data class  DeletePersona(val persona: Persona): HomeEvent()
}
