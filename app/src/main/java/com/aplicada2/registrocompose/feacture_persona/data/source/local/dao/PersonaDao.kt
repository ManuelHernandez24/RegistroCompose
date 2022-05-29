package com.aplicada2.registrocompose.feacture_persona.data.source.local.dao

import androidx.room.*
import com.aplicada2.registrocompose.feacture_persona.domain.model.Persona
import  kotlinx.coroutines.flow.Flow

interface PersonaDao {

    @Query("Select * from Persona")
    fun getAllPersona(): Flow<List<Persona>>

    @Query("Select * from Persona where PersonaId = :personaId")
    suspend fun getPersonaById(personaId: Int): Persona?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPersona(persona: Persona)

    @Delete
    suspend fun deletePersona(persona: Persona)



}