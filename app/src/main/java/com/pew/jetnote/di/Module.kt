package com.pew.jetnote.di

import android.content.Context
import androidx.room.Room
import com.pew.jetnote.data.NoteDao
import com.pew.jetnote.data.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class Module {

    @Singleton
    @Provides
    fun provideNoteDataBaseDao(noteDatabase: NoteDatabase): NoteDao {
        return noteDatabase.noteDao()
    }

    @Singleton
    @Provides
    fun provideNoteDatabase(@ApplicationContext context: Context): NoteDatabase
    = Room.databaseBuilder(context,
        NoteDatabase::class.java,
        "Note_DB").fallbackToDestructiveMigration().build()
}