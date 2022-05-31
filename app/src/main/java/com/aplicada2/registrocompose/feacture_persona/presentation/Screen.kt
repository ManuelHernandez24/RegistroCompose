package com.aplicada2.registrocompose.feacture_persona.presentation

sealed class Screen(val route: String){
    object Home: Screen("Home")
    object Edit: Screen("edit?personaId={personId}"){
        fun passId(personaId: Int?): String {
            return "edit?personaId=$personaId"
        }
    }
}
