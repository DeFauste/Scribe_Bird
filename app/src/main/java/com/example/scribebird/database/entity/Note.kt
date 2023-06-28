package com.example.scribebird.database.entity

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val textTitle: String,
    val textDesc: String,
    val weather: Int,
    val time: Date,
    val emotion:Int,
    val image: BitmapDrawable
)