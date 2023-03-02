package com.card3333333.jetnoteapp.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.card3333333.jetnoteapp.data.NoteDateSource
import com.card3333333.jetnoteapp.model.Note
import com.card3333333.jetnoteapp.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(val repository: NoteRepository) : ViewModel() {
    //    private var noteList = mutableStateListOf<Note>()
    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteLIst = _noteList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged().collect { listOfNote ->
                run {
                    if (listOfNote.isNullOrEmpty()) {
                        Log.e("TAG", ": Empty list")
                    } else {
                        _noteList.value = listOfNote
                    }
                }

            }
        }
    }

    fun addNote(note: Note) = viewModelScope.launch { repository.addNote(note) }

    fun removeNote(note: Note) = viewModelScope.launch { repository.deleteANote(note) }

    fun updateNote(note: Note) = viewModelScope.launch { repository.updateNote(note) }

    fun removeNoteByUpdate(id: String) = viewModelScope.launch { repository.deleteNoteById(id) }

}