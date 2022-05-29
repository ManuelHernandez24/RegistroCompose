package com.aplicada2.registrocompose.feacture_persona.domain.use_cases

import com.aplicada2.registrocompose.feacture_persona.domain.model.Persona
import com.aplicada2.registrocompose.feacture_persona.domain.repository.PersonaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllPersona @Inject constructor(
    private val repository: PersonaRepository
) {
    operator fun invoke(): Flow<List<Persona>>{
        return repository.getAllPersona()
    }
}