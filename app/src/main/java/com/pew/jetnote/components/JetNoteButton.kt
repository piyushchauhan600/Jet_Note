package com.pew.jetnote.components

import android.content.pm.PackageManager.ComponentEnabledSetting
import android.graphics.drawable.shapes.Shape
import android.widget.Button
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Button(
    text: String,
    onClick:  () -> Unit,
    colors: ButtonColors,
    shape: androidx.compose.ui.graphics.Shape,
    modifier: Modifier,
    enabledSetting: Boolean

) {
    ElevatedButton(onClick = onClick,
        modifier = modifier,
        shape = shape,
        colors = colors,
        elevation = ButtonDefaults.elevatedButtonElevation(10.dp),
        enabled = enabledSetting,

    ) {
        Text(text = text,
        )
    }

}
