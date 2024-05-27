package com.pew.jetnote.notescreen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pew.jetnote.components.Button
import com.pew.jetnote.components.SavedNotes
import com.pew.jetnote.components.textField
import com.pew.jetnote.data.NoteData
import com.pew.jetnote.model.Note
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    notes: List<com.pew.jetnote.model.Note>,
    addNote: (com.pew.jetnote.model.Note) -> Unit,
    deleteNote: (com.pew.jetnote.model.Note) -> Unit,
) {
    val context = LocalContext.current
    var title by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Top App Bar
        TopAppBar(title = {
            Text(
                text = "JetNote",
                color = Color.White
            )
        },
            colors = TopAppBarDefaults.topAppBarColors(Color.Blue),
            actions = {
                Icon(
                    imageVector = Icons.Default.Notifications, contentDescription = "Notfication",
                    tint = Color.White
                )
            }
        )
        Spacer(modifier = Modifier.padding(15.dp))
        // First Title Text Field
        textField(
            value = title,
            onValueChange = {
                if(it.all { char -> char.isLetter() || char.isWhitespace() })
                title = it
            },
            enabled = true,
            label = "Add title",
            modifier = Modifier.padding(6.dp),
        )
        // Second Text Field
        textField(
            value = description,
            onValueChange = {
                if (it.all { char -> char.isLetter() || char.isWhitespace() })
                description = it
            },
            enabled = true,
            label = "Add note",
            modifier = Modifier.padding(6.dp),
        )
        //Button
        Button(
            text = "Save",
            onClick = {
                if(title.isNotEmpty() && description.isNotEmpty()) {
                    addNote(
                        Note(
                            title = title,
                            description = description
                        )
                    )
                    title = ""
                    description = ""
                    Toast.makeText(context, "Note Added", Toast.LENGTH_LONG).show()
                }
                      },

            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = shape,
            modifier = Modifier.padding(20.dp),
            enabledSetting = true,
            
        )
        Divider(modifier = Modifier.width(330.dp))

        //Note List Lazy Columns
        LazyColumn {
            items(items = notes) {
                SavedNotes(it) {
                    deleteNote(it)
                }
            }
        }

    }
}