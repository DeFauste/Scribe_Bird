package com.example.scribebird.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note:NoteEntity)

    @Query("SELECT * FROM note_table ORDER BY id ASC")
    fun readAllNote() : Flow<List<NoteEntity>>
}