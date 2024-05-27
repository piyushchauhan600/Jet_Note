package com.pew.jetnote.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pew.jetnote.model.Note
import com.pew.jetnote.utils.DateConvertor
import com.pew.jetnote.utils.UuidConvertor
import kotlinx.coroutines.InternalCoroutinesApi


@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConvertor::class,UuidConvertor::class)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>I Am Use Hilt TO Make Singleton DataBase Object Instead Of This<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
//    companion object {
//        @Volatile
//        private var INSTANCE: NoteDatabase? = null
//
//        @OptIn(InternalCoroutinesApi::class)
//        public fun getDatabase(context: Context): NoteDatabase {
//            kotlinx.coroutines.internal.synchronized(this) {
//                if (INSTANCE == null) {
//                    INSTANCE = Room.databaseBuilder(context,
//                        NoteDatabase::class.java,
//                        "Note_DataBase").build()
//                }
//                return INSTANCE!!
//            }
//        }
//    }
}