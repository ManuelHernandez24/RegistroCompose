package com.aplicada2.registrocompose.feacture_persona.presentation.edit

sealed class EditEvent{
    data class EnteredNombres(val value: String): EditEvent()
    data class EnteredEmail(val value: String): EditEvent()
    data class EnteredOcupacionId(val value: String): EditEvent()
    data class EnteredBalance(val value: String): EditEvent()
    object InsertPersona: EditEvent()
}
