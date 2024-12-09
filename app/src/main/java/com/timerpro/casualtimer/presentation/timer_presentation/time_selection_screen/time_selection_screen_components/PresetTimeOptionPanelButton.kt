package com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_components

import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.timerpro.casualtimer.data.shared_data.Colors
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.time_selection_screen_dimensions.TimeSelectionScreenDimensions
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.general_functionality.generalFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.presetTimeFunctionality

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PresetTimeOptionPanelButton(
    context: Context,
    configuration: Configuration,
    modifier: Modifier = Modifier,
    dimensions: TimeSelectionScreenDimensions = TimeSelectionScreenDimensions(configuration),
    text: String,
) {

    fun determineColor(): Color {
        return if (text == "Edit" && timerStates.selectedPresetTimeList.size > 1
            ) Colors().lightGray else Colors().darkGray
    }

    Column(
        modifier
            .padding(bottom = dimensions.presetTimeOptionsPanelBottomPadding)
            .combinedClickable(
                enabled = text.let { it == "Close" || it == "Delete" ||
                        it == "Edit" && timerStates.selectedPresetTimeList.size == 1
                },
                onClick = {
                    generalFunctionality.vibrateOnButtonClick(context = context)
                    when (text) {
                        "Close" -> {
                            timerStates.isPresetTimeOptionPanelVisible = false
                            timerStates.selectedPresetTimeList = listOf()
                        }
                        "Edit" -> {
                            timerStates.isPresetTimeBeingEdited = true
                            timerStates.isAddPresetTimeDialogOpen = true
                            presetTimeFunctionality.loadPresetTimeToDialog(presetTime = timerStates.selectedPresetTimeList[0])
                        }
                        else -> {
                            presetTimeFunctionality.deletePresetTime(context = context, list = timerStates.selectedPresetTimeList)
                            timerStates.selectedPresetTimeList = listOf()}
                }})
            ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Icon(
            imageVector = when (text) {
                "Close" -> Icons.Outlined.Clear
                "Edit" -> Icons.Outlined.Edit
                else -> Icons.Outlined.Delete
            },
            contentDescription = null,
            modifier.size(dimensions.presetTimeOptionsPanelIconSize),
            tint = determineColor()
        )

        Text(
            text = text,
            color = determineColor(),
            fontSize = dimensions.presetTimeOptionsPanelFontSize,
            letterSpacing = dimensions.presetTimeOptionsPanelLetterSpacing)
    }
}