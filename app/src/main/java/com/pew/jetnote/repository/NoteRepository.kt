package com.pew.jetnote.repository

import com.pew.jetnote.data.NoteDao
import com.pew.jetnote.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class NoteRepository @Inject constructor(private val noteDao: NoteDao) {
    suspend fun insertNote(note: Note) = noteDao.insert(note)
    suspend fun updateNote(note: Note) = noteDao.Update(note)
    suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)
    suspend fun deleteAllNote() = noteDao.deleteAll()
    fun getsAllNotes(): Flow<List<Note>> = noteDao.getNote().flowOn(Dispatchers.IO).conflate()

}