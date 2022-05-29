package com.aplicada2.registrocompose.di

import android.app.Application
import androidx.room.Room
import com.aplicada2.registrocompose.feacture_persona.data.repository.PersonaRepositoryImplementation
import com.aplicada2.registrocompose.feacture_persona.data.source.local.PersonaDatabase
import com.aplicada2.registrocompose.feacture_persona.domain.repository.PersonaRepository
import com.aplicada2.registrocompose.utils.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePersonaDatabase(app: Application) = Room.databaseBuilder(
        app,
        PersonaDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideRepository(db: PersonaDatabase): PersonaRepository{
        return PersonaRepositoryImplementation(db.personaDao)
    }
}