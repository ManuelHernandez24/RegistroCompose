package com.aplicada2.registrocompose.feacture_persona.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aplicada2.registrocompose.feacture_persona.data.local.dao.PersonaDao
import com.aplicada2.registrocompose.feacture_persona.domain.model.Persona

@Database(
    entities = [Persona::class],
    version = 1,
    exportSchema = false
)
abstract class PersonaDatabase: RoomDatabase() {
    abstract val personaDao: PersonaDao
}