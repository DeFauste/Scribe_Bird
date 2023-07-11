package com.example.scribebird.database

import kotlinx.coroutines.flow.Flow

class NoteRepository(private val noteDao: NoteDao) {

    val readAllData: Flow<List<NoteEntity>> = noteDao.readAllNote()


    suspend fun addNote(note: NoteEntity) {
        noteDao.addNote(note)
    }
}