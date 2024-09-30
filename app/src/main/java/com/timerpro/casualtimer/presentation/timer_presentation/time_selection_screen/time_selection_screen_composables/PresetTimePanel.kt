package com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.timerpro.casualtimer.functionality.timer_functionality.presetTimeFunctionality

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PresetTimePanel(
    timeFontSize: Int,
    nameFontSize: Int,
    name : String,
    seconds: Int,
    minutes: Int,
    hours: Int,
    formattedTime: String = "%02d:%02d:%02d".format(hours, minutes, seconds),
    onLongClick: () -> Unit) {

    // Preset Time Panel Layout
    Column (
        modifier = Modifier
            .combinedClickable(

                // Covert Time To Preset Time
                onClick = { presetTimeFunctionality.covertTimeToPresetTime(
                    seconds = seconds,
                    minutes = minutes,
                    hours = hours) },

                // Open Edit Preset Time Dialog
                onLongClick = { onLongClick() })

            .width(timeFontSize.dp * 4.50f)) {

            // Preset Time Panel Name Text
            Text(
                text = name,
                fontSize = nameFontSize.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis)

            // Preset Time Panel Time Text
            Text(
                text = formattedTime,
                fontSize = timeFontSize.sp,
                fontWeight = FontWeight.SemiBold)
    }
}