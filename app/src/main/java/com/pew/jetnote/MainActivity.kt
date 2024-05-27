package com.pew.jetnote

import android.graphics.DiscretePathEffect
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.pew.jetnote.model.Note
import com.pew.jetnote.notescreen.NoteScreen
import com.pew.jetnote.notescreen.NoteViewModel
import com.pew.jetnote.ui.theme.JetNoteTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val notesViewModel by viewModels<NoteViewModel>()
            NotesApp(notesViewModel = notesViewModel)
        }
    }
}

@Composable
fun NotesApp(notesViewModel: NoteViewModel) {
    val notesList = notesViewModel.noteLList.collectAsState(emptyList())

    NoteScreen(
        notes = notesList.value,
        addNote = { notesViewModel.addNote(it)},
        deleteNote = { notesViewModel.deleteNote(it)},
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}