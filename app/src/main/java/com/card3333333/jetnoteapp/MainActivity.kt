package com.card3333333.jetnoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.card3333333.jetnoteapp.data.NoteDateSource
import com.card3333333.jetnoteapp.model.Note
import com.card3333333.jetnoteapp.screen.NoteScreen
import com.card3333333.jetnoteapp.screen.NoteViewModel
import com.card3333333.jetnoteapp.ui.theme.JetNoteAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetNoteAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    val noteViewModel: NoteViewModel by viewModels()
                   notesApp(noteViewModel)
                }
            }
        }
    }
}

@Composable
fun notesApp(noteViewModel: NoteViewModel){
    val noteList = noteViewModel.noteLIst.collectAsState().value

    NoteScreen(notes = noteList, onAddNote = { note ->
        noteViewModel.addNote(note)
    }, onRemoveNote = { note ->
        noteViewModel.removeNote(note)
    })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetNoteAppTheme {
    }
}