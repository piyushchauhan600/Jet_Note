package com.pew.jetnote.notescreen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.pew.jetnote.model.Note
import com.pew.jetnote.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(val repository: NoteRepository) : ViewModel() {
    // private val notesList = mutableStateListOf<Note>()
    // Add A Flow State
    val mutableSharedFlow =  MutableSharedFlow<List<Note>>()
    val noteLList = mutableSharedFlow.asSharedFlow()

    // Load Notes Source Notes Into Notelist
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getsAllNotes()
                .distinctUntilChanged()
                .collect { listOfNotes ->
                        mutableSharedFlow.emit(listOfNotes)
                        Log.d("Notes",listOfNotes.toString())
                }
        }
    }

    // Adding A Notes In View Model
    fun addNote(note: Note) = viewModelScope.launch { repository.insertNote(note) }

    // Delete A Notes In View Model
    fun deleteNote(note: Note) = viewModelScope.launch { repository.deleteNote(note)
        // ...
// Delete A Notes In View Model
        fun deleteNote(note: Note) = viewModelScope.launch {
            repository.deleteNote(note)
        } }

    // Gets A Notes Update
    fun updateNote(note: Note) = viewModelScope.launch { repository.updateNote(note) }


}