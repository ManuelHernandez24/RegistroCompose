package com.aplicada2.registrocompose.feacture_persona.presentation.home

import com.aplicada2.registrocompose.feacture_persona.domain.model.Persona

data class HomeState (
    val personas: List<Persona> = emptyList()
    )