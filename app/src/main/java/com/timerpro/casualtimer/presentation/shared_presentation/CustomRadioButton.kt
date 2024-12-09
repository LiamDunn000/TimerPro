package com.timerpro.casualtimer.presentation.shared_presentation

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.timerpro.casualtimer.data.shared_data.dimensions.CustomRadioDimensions
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.shared_presentation_management.CustomRadioButtonManagement

@Composable
fun CustomRadioButton(
    configuration: Configuration,
    dimensions: CustomRadioDimensions = CustomRadioDimensions(configuration),
    functionality: CustomRadioButtonManagement = CustomRadioButtonManagement(),
    title: String,
    isSelected: Boolean = false,
    text: String = timerStates.alarmSoundNames[0],
) {

    // Custom Radio Button Layout
    Box(modifier = Modifier
        .padding(
            top = dimensions.externalPadding,
            end = dimensions.externalPadding)
        .size(dimensions.buttonSize)
        .clip(shape = CircleShape)
        .border(color = functionality.determineButtonBorderColor(
                title = title, text = text, isSelected = isSelected
        ),
            width = dimensions.borderWidth,
            shape = CircleShape),
        contentAlignment = Alignment.Center){

        // Custom Radio Button Indicator
        Box(modifier = Modifier
            .background(color = functionality.determineButtonIndicatorColor(
                    title = title, text = text, isSelected = isSelected
                ),
                shape = CircleShape)
            .fillMaxSize(0.5f)) }}