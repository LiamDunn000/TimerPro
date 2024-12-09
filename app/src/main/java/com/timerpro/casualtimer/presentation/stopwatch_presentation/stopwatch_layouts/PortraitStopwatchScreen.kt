package com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_layouts

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.timerpro.casualtimer.data.shared_data.Colors
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_dimensions.StopwatchScreenDimensions
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_states.stopwatchStates
import com.timerpro.casualtimer.functionality.general_functionality.generalFunctionality
import com.timerpro.casualtimer.presentation.shared_presentation.GeneralPurposeButton
import com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_components.LapDisplayList
import com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_components.LapDisplayListHeader
import com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_components.StopwatchTimeDisplay

@Composable
fun PortraitStopwatchScreen(
    modifier: Modifier = Modifier,
    context: Context,
    configuration: Configuration,
    dimensions: StopwatchScreenDimensions = StopwatchScreenDimensions(configuration),
    lapDisplayListState: LazyListState) {

    // Logic That Closes Application When Back Button Is Pressed
    BackHandler{ (context as? Activity)?.moveTaskToBack(true)}

    // Move Slide To Stopwatch If Deep Link Is Clicked
    generalFunctionality.moveSliderToStopwatchIfDeepLinkIsClicked(context)

    // Portrait Stopwatch Screen Layout
    Column(
        modifier
            .background(color = Colors().white)
            .padding(
                vertical = dimensions.portraitVerticalPadding,
                horizontal = dimensions.portraitHorizontalPadding
            )
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Spacer(modifier.weight(animateFloatAsState(dimensions.portraitTopSpacerWeight).value))

        // Portrait Current Stopwatch Time Display
        StopwatchTimeDisplay(timerType = "Current", configuration = configuration)

        // Portrait Lap Stopwatch Time Display
        AnimatedVisibility(visible = stopwatchStates.isLapStopwatchVisible) {
            StopwatchTimeDisplay(timerType = "Lap", configuration = configuration)
        }

        // Portrait Lap Display List
        Column(
            modifier = modifier.weight(dimensions.lapDisplayListWeight)) {
            LapDisplayListHeader(configuration = configuration)
            LapDisplayList(configuration = configuration, lapDisplayListState = lapDisplayListState)
        }

        // Portrait Stopwatch Button Panel
        Row(
            modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {

            // Portrait Toggle Stopwatch Button
            GeneralPurposeButton(
                configuration = configuration,
                title = "Toggle Stopwatch")

            // Portrait Lap And Reset Stopwatch Button
            AnimatedVisibility(visible = stopwatchStates.isLapAndResetStopwatchButtonVisible
            ) {
                GeneralPurposeButton(
                    configuration = configuration,
                    title = "Lap And Reset Stopwatch",
                    lapDisplayListState = lapDisplayListState)
            }
        }
    }
}