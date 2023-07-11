package com.example.scribebird.presentation.fragment

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.scribebird.database.NoteDatabase
import com.example.scribebird.database.NoteEntity
import com.example.scribebird.database.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : ViewModel() {

    val readAllData: Flow<List<NoteEntity>>
    private val repository: NoteRepository

    init {
        val noteDao = NoteDatabase.getDatabase(application).noteDao()
        repository = NoteRepository(noteDao)
        readAllData = repository.readAllData
    }

    fun addNote(note: NoteEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.addNote(note)
    }
}