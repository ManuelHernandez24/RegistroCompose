package com.aplicada2.registrocompose.feacture_persona.domain.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aplicada2.registrocompose.feacture_persona.domain.model.Persona
import kotlinx.coroutines.flow.Flow

interface PersonaRepository {

    fun getAllPersona():Flow<List<Persona>>
    suspend fun getPersonaById(personaId: Int): Persona?
    suspend fun insertPersona(persona: Persona)
    suspend fun deletePersona(persona: Persona)
}