package com.card3333333.jetnoteapp.repository

import com.card3333333.jetnoteapp.data.NoteDatabaseDao
import com.card3333333.jetnoteapp.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteDatabaseDao: NoteDatabaseDao) {
    suspend fun addNote(note: Note) = noteDatabaseDao.insert(note)
    suspend fun updateNote(note: Note) = noteDatabaseDao.update(note)
    suspend fun deleteNoteById(id: String) = noteDatabaseDao.getNoteById(id)
    suspend fun deleteANote(note: Note) = noteDatabaseDao.deleteNote(note)
    suspend fun deleteAllNote() = noteDatabaseDao.deleteAll()
    suspend fun getAllNotes(): Flow<List<Note>> = noteDatabaseDao.getNotes()
        .flowOn(Dispatchers.IO).conflate()
}