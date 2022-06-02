package com.aplicada2.registrocompose.feacture_persona.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.aplicada2.registrocompose.R
import com.aplicada2.registrocompose.feacture_persona.presentation.Screen

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
){
    val state = viewModel.state.value

    Scaffold(
        topBar = {
            HomeTopBar()
        },
        floatingActionButton = {
            HomeFab(
                onFabClicked = { navController.navigate(Screen.Edit.route)}
            )
        }
    ) {

    }
}



@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier
) {
    TopAppBar (
        title = {
            Text(
                text = stringResource(id = R.string.personas),
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        },
        backgroundColor = MaterialTheme.colors.surface
    )
}

@Composable
fun HomeFab(
    modifier: Modifier = Modifier,
    onFabClicked: () -> Unit = {}
) {

    FloatingActionButton(
        onClick = onFabClicked,
        modifier = modifier
            .height(52.dp)
            .widthIn(min = 52.dp),
        backgroundColor = MaterialTheme.colors.primary
        )
    {
    Icon(
        imageVector = Icons.Outlined.Add,
        contentDescription = null)
    }

}