package com.aplicada2.registrocompose.feacture_persona.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Persona(
    @PrimaryKey(autoGenerate = true)
    val PersonaId: Int?,
    val Nombres: String,
    val Email: String,
    val OcupacionId: Int,
    val Balance: Double
)
