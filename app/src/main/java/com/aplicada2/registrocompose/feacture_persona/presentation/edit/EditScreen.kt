package com.aplicada2.registrocompose.feacture_persona.presentation.edit.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aplicada2.registrocompose.feacture_persona.presentation.edit.EditViewModel

@Composable
fun EditScreen(
    navController: NavController,
    viewModel: EditViewModel = hiltViewModel()
){}