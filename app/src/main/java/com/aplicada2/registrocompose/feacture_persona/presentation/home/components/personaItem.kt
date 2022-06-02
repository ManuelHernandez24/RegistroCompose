package com.aplicada2.registrocompose.feacture_persona.presentation.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.aplicada2.registrocompose.feacture_persona.domain.model.Persona
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun PersonaItem(
    modifier: Modifier,
    persona: Persona,
    onEditPersona: () -> Unit,
    onDeletePersona: ()-> Unit
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp, vertical = 12.dp),
        elevation = 3.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ){
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = "${persona.PersonaId}",
                    style = MaterialTheme.typography.caption.copy(color = Color.DarkGray)
                )
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "${persona.Nombres}",
                    style = MaterialTheme.typography.h6
                )
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "${persona.OcupacionId}",
                    style = MaterialTheme.typography.caption.copy(color = Color.DarkGray)
                )
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "${persona.Email}",
                    style = MaterialTheme.typography.caption.copy(color = Color.DarkGray)
                )
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "${persona.Balance} $",
                    style = MaterialTheme.typography.caption.copy(color = Color.DarkGray)
                )
                Spacer(modifier = Modifier.height(4.dp))

            }
            Row {
               IconButton(onClick = onEditPersona) {
                   Icon(
                       imageVector = Icons.Filled.Edit,
                       contentDescription = null,
                       tint = Color.Green
                   )
               }

                IconButton(onClick = onDeletePersona) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = null,
                        tint = Color.Red
                    )
                }
            }
        }
    }
}