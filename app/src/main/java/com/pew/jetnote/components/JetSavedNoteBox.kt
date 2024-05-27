package com.pew.jetnote.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pew.jetnote.data.NoteData
import com.pew.jetnote.model.Note
import com.pew.jetnote.utils.formatDate
import java.time.format.DateTimeFormatter



@Composable
fun SavedNotes(
    note: Note,
    onClick: (Note) -> Unit,
) {
    Card(
        modifier = Modifier
            .clickable { onClick(note) }
            .padding(horizontal = 10.dp, vertical = 6.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(3.dp)),
        elevation = CardDefaults.outlinedCardElevation(),
        colors = CardDefaults.cardColors(containerColor = Color(0xffCDE8E5))
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Note Row Title
                Text(
                    text = note.title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(start = 8.dp, top = 2.dp)
                )
               //  Note Row Date
                Text(
                    text = formatDate(note.entryDate.time),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(3.dp)
                )
            }

            // Note Title Description
            Text(text = note.description,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(start = 8.dp, top = 2.dp, bottom = 4.dp)


                )

        }
    }

}