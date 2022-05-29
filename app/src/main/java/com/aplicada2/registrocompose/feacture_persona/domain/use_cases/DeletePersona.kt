package com.aplicada2.registrocompose.feacture_persona.domain.use_cases

import com.aplicada2.registrocompose.feacture_persona.domain.model.Persona
import com.aplicada2.registrocompose.feacture_persona.domain.repository.PersonaRepository
import javax.inject.Inject

class DeletePersona @Inject constructor(
    private val  repository: PersonaRepository
) {
    suspend operator fun invoke(persona: Persona){
        repository.deletePersona(persona)
    }
}