package com.aplicada2.registrocompose.feacture_persona.presentation.edit.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aplicada2.registrocompose.R
import com.aplicada2.registrocompose.feacture_persona.presentation.edit.EditEvent
import com.aplicada2.registrocompose.feacture_persona.presentation.edit.EditViewModel

@Composable
fun EditScreen(
    navController: NavController,
    viewModel: EditViewModel = hiltViewModel()
){
    val nombresState = viewModel.personaNombres.value
    val emailState = viewModel.personaEmail.value
    val ocupacionIdState = viewModel.personaOcupacionId.value
    val balanceState = viewModel.personaBalance.value

    Scaffold(
        topBar = {
            EditTopBar(
                topAppBarText = stringResource(id = R.string.add_persona)
            )
        },
        content = {
            EditContent(
                nombres = nombresState.text,
                email = emailState.text,
                ocupacionId = ocupacionIdState.text,
                balance = balanceState.text,
                onEvent = { viewModel.onEvent(it)}
            )
        },
        bottomBar = {
            EditBottonBar(
                onInsertPersona = { viewModel.onEvent(EditEvent.InsertPersona) }
            )
        }
    )
}

@Composable
fun EditTopBar(topAppBarText: String) {
    TopAppBar(
        title = {
            Text(
                text = topAppBarText,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        },
        backgroundColor = MaterialTheme.colors.surface
    )
}


@Composable
fun EditContent(
    nombres: String, 
    email: String, 
    ocupacionId: String, 
    balance: String, 
    onEvent: (EditEvent) -> Unit) {
    
    Column(
        modifier = Modifier.fillMaxWidth()) {
        Spacer(
            modifier = Modifier.height(44.dp))
        PersonaInputText(
            text = nombres, 
            hint = stringResource(id = R.string.nombres),
            onTextChange = { onEvent(EditEvent.EnteredNombres(it))})

        PersonaInputText(
            text = email,
            hint = stringResource(id = R.string.email),
            onTextChange = { onEvent(EditEvent.EnteredEmail(it))})

        PersonaInputText(
            text = ocupacionId,
            hint = stringResource(id = R.string.ocupacion),
            onTextChange = { onEvent(EditEvent.EnteredOcupacionId(it))})

        PersonaInputText(
            text = balance,
            hint = stringResource(id = R.string.balance),
            onTextChange = { onEvent(EditEvent.EnteredBalance(it))})
    }
}


@Composable
fun EditBottonBar(
    modifier: Modifier = Modifier,
    onInsertPersona: () -> Unit) 
{
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 14.dp),
        onClick = {onInsertPersona()}) {
        
        Text(
            text = stringResource(id = R.string.add_persona))
    }
}

