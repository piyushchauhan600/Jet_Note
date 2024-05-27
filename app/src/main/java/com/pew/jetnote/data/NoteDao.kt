package com.pew.jetnote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.pew.jetnote.model.Note
import kotlinx.coroutines.flow.Flow
import java.text.Normalizer.Form


@Dao
interface NoteDao {

    @Query("SELECT * FROM NOTE_TABLE")
    fun getNote(): Flow<List<Note>>

    @Query("SELECT * FROM  Note_Table WHERE uuid =:Id")
    suspend fun getNoteById(Id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Update(note: Note)

    @Query("DELETE  FROM NOTE_TABLE")
    suspend fun deleteAll()

    @Delete()
    suspend fun  deleteNote(note: Note)

}