package com.timerpro.casualtimer.presentation.timer_presentation.add_preset_time_dialog.add_preset_time_dialog_components

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import com.timerpro.casualtimer.data.shared_data.Colors
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.preset_time_dialog_dimensions.PresetTimeDialogDimensions
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates

@Composable
fun PresetTimeTitleTextField(
    configuration: Configuration,
    dimensions: PresetTimeDialogDimensions = PresetTimeDialogDimensions(configuration),
) {

    TextField(
        value = timerStates.presetTimeTitleTextFieldValue,
        onValueChange = { newText ->
            if (newText.length <= 25) timerStates.presetTimeTitleTextFieldValue = newText
            timerStates.areChangesMadeToPresetTime = true
                        },
        textStyle = TextStyle(
            fontSize = dimensions.titleTextFieldFontSize,
        ),
        placeholder = {
            Text("Preset Time Name",
            fontSize = dimensions.titleTextFieldFontSize)},
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Colors().transparent,
            focusedContainerColor = Colors().transparent,
        ),
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .height(height = dimensions.titleTextFieldHeight),
    )
}