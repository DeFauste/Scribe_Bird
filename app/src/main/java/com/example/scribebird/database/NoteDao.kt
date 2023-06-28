package com.example.scribebird.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.scribebird.database.entity.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM note_table")
    fun getNotes(): Flow<List<Note>>

    @Insert
    fun insertNote(note: Note)
}