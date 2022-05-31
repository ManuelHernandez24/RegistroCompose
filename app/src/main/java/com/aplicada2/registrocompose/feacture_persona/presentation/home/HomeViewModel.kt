package com.aplicada2.registrocompose.feacture_persona.presentation.home

import androidx.lifecycle.ViewModel
import com.aplicada2.registrocompose.feacture_persona.domain.use_cases.DeletePersona
import com.aplicada2.registrocompose.feacture_persona.domain.use_cases.GetAllPersona
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val deletePersona: DeletePersona,
    private val getAllPersona: GetAllPersona,
): ViewModel() {

}