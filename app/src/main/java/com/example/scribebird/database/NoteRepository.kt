package com.example.scribebird.database

import androidx.annotation.WorkerThread
import com.example.scribebird.database.entity.Note
import kotlinx.coroutines.flow.Flow

class NoteRepository(private val noteDao: NoteDao) {

    val allNote: Flow<List<Note>> = noteDao.getNotes()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(note: Note) {
        noteDao.insertNote(note)
    }
}