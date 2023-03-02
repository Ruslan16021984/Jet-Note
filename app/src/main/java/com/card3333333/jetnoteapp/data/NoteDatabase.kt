package com.card3333333.jetnoteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.card3333333.jetnoteapp.model.Note
import com.card3333333.jetnoteapp.utils.Converters
import com.card3333333.jetnoteapp.utils.UUIDConverter

@Database(entities = [Note::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class, UUIDConverter::class)
abstract class NoteDatabase: RoomDatabase() {
   abstract fun noteDatabase() : NoteDatabaseDao
}