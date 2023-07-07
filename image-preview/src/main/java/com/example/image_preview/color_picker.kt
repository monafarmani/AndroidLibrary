package com.example.image_preview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import com.godaddy.android.colorpicker.harmony.ColorHarmonyMode
import com.godaddy.android.colorpicker.harmony.HarmonyColorPicker

@Composable
fun ColorPicker(modifier: Modifier ) {
    var sss = remember {
      mutableStateOf(Color.Black)
    }
    Column {

        HarmonyColorPicker(
            harmonyMode = ColorHarmonyMode.SHADES,
            modifier = modifier.size(400.dp),
            onColorChanged = { color ->
                // do stuff with new color
                sss.value = color.toColor()
            }
        )
        Text(text ="hello world" , color= sss.value , modifier = modifier.align(alignment = Alignment.CenterHorizontally))

    }
}









