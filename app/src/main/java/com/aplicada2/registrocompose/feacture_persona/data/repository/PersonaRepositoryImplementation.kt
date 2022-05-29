package com.aplicada2.registrocompose.feacture_persona.data.repository

import com.aplicada2.registrocompose.feacture_persona.data.source.local.dao.PersonaDao
import com.aplicada2.registrocompose.feacture_persona.domain.model.Persona
import com.aplicada2.registrocompose.feacture_persona.domain.repository.PersonaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PersonaRepositoryImplementation @Inject constructor(
    private val dao: PersonaDao
): PersonaRepository {
    override fun getAllPersona(): Flow<List<Persona>> {
        return dao.getAllPersona()
    }

    override suspend fun getPersonaById(personaId: Int): Persona? {
        return dao.getPersonaById(personaId)
    }

    override suspend fun insertPersona(persona: Persona) {
        dao.insertPersona(persona)
    }

    override suspend fun deletePersona(persona: Persona) {
        dao.deletePersona(persona)
    }
}