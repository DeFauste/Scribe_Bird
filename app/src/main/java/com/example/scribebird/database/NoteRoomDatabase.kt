package com.example.scribebird.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

public abstract class NoteRoomDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile
        private var INSTANCE: NoteRoomDatabase? = null

        fun getDatabase(context: Context): NoteRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteRoomDatabase::class.java,
                    "note_table"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}