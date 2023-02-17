package com.card3333333.jetnoteapp.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.card3333333.jetnoteapp.R
import com.card3333333.jetnoteapp.components.NoteButton
import com.card3333333.jetnoteapp.components.NoteInputText

@Composable
fun NoteScreen() {
    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.padding(6.dp)) {
        TopAppBar(title = {
            Text(text = stringResource(id = R.string.app_name))
        }, actions = {
            Icon(imageVector = Icons.Rounded.Notifications, contentDescription = "Icon Notification")
        },
        backgroundColor = Color(0xFFDADFE3)
        )
        Column(modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
            NoteInputText(text = title, label = "title", onTextChange = {
                                                                        if (it.all { char ->
                                                                                char.isLetter() || char.isWhitespace()
                                                                            }) title = it
            }, modifier = Modifier.padding(
                top = 9.dp,
                bottom = 8.dp
            ))
            NoteInputText(text = description, label = "Add a note", onTextChange = {
                if (it.all { char ->
                        char.isLetter() || char.isWhitespace()
                    }) description = it
            }, modifier = Modifier.padding(
                top = 9.dp,
                bottom = 8.dp
            ))
            NoteButton(text = "Save", onClick = { /*TODO*/ })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen()
}