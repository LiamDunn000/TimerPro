package com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_components

import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.timerpro.casualtimer.data.shared_data.Colors
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.time_selection_screen_dimensions.TimeSelectionScreenDimensions
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.general_functionality.generalFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.PresetTimeFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.presetTimeFunctionality
import com.timerpro.casualtimer.presentation.shared_presentation.CustomRadioButton
import com.timerpro.timertest.data.PresetTime

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PresetTimePanel(
    context: Context,
    configuration: Configuration,
    modifier: Modifier = Modifier,
    dimensions: TimeSelectionScreenDimensions = TimeSelectionScreenDimensions(configuration),
    functionality: PresetTimeFunctionality = presetTimeFunctionality,
    presetTime: PresetTime,
    orientation: String,
    formattedTime: String = presetTime.let { "%02d:%02d:%02d".format(
         it.hours, it.minutes, it.seconds)},
    ) {

    var isSelected by rememberSaveable(key = presetTime.id.toString()) { mutableStateOf(false) }

    isSelected = presetTime in timerStates.selectedPresetTimeList

    fun addOrRemovePresetTimeFromList() {
        isSelected = !isSelected
        functionality.addOrRemovePresetTimeFromList(
            presetTime = presetTime,
            isSelected = isSelected
        )
    }

    LaunchedEffect(timerStates.selectedPresetTimeList) {
        if (timerStates.selectedPresetTimeList.isEmpty()) isSelected = false}

    // Preset Time Panel Container
    Box(modifier
        .padding(dimensions.presetTimePanelPadding)
        .shadow(
            elevation = dimensions.presetTimePanelElevation,
            shape = RoundedCornerShape(dimensions.presetTimePanelCornerRadius))
        .background(
            color = Colors().mediumDarkWhite,
            shape = RoundedCornerShape(dimensions.presetTimePanelCornerRadius)
        ),
        contentAlignment = Alignment.TopEnd) {

        // Button That Indicates If Preset Time Is Selected
        CustomRadioButton(
            configuration = configuration,
            title = "Preset Time Button",
            isSelected = isSelected)

        // Preset Time Panel Layout
        Column(
            modifier = Modifier
                .combinedClickable(

                    // Covert Time To Preset Time If None Are Selected
                    onClick = {
                        generalFunctionality.vibrateOnButtonClick(context = context)
                        if (timerStates.selectedPresetTimeList.isEmpty())
                            presetTime.let {
                        presetTimeFunctionality.covertTimeToPresetTime(
                            seconds = it.seconds,
                            minutes = it.minutes,
                            hours = it.hours
                        )} else addOrRemovePresetTimeFromList()
                    },

                    // Select Preset Time
                    onLongClick = {
                        generalFunctionality.vibrateOnButtonClick(context = context)
                        addOrRemovePresetTimeFromList() }
                )
                .width(dimensions.presetTimePanelWidth(orientation = orientation))
                .padding(dimensions.presetTimePanelPadding)
        ) {

            // Preset Time Panel Name Text
            Text(
                text = presetTime.name,
                color = Colors().gray,
                fontSize = dimensions.presetTimePanelTitleFontSize(orientation = orientation),
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            // Preset Time Panel Time Text
            Text(
                text = formattedTime,
                color = Colors().darkGray,
                fontSize = dimensions.presetTimePanelTimeFontSize(orientation = orientation),
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}