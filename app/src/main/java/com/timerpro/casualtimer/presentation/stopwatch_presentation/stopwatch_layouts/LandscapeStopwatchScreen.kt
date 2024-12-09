package com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_layouts

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.timerpro.casualtimer.data.shared_data.Colors
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_dimensions.StopwatchScreenDimensions
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_states.stopwatchStates
import com.timerpro.casualtimer.functionality.general_functionality.generalFunctionality
import com.timerpro.casualtimer.presentation.shared_presentation.GeneralPurposeButton
import com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_components.LapDisplayList
import com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_components.LapDisplayListHeader
import com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_components.StopwatchTimeDisplay

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LandscapeStopwatchScreen(
    configuration: Configuration,
    dimensions: StopwatchScreenDimensions = StopwatchScreenDimensions(configuration = configuration),
    context: Context,
    lapDisplayListState: LazyListState) {

    // Logic That Closes Application When Back Button Is Pressed
    BackHandler{ (context as? Activity)?.moveTaskToBack(true)}

    // Move Slide To Stopwatch If Deep Link Is Clicked
    generalFunctionality.moveSliderToStopwatchIfDeepLinkIsClicked(context)

    // Landscape Stopwatch Screen Layout
        Row(
            modifier = Modifier
                .background(color = Colors().white)
                .padding(vertical = dimensions.landscapeVerticalPadding)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Left Landscape Stopwatch Screen Panel
            Column(
                modifier = Modifier
                    .width(dimensions.landscapePanelWidth.dp)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                // Landscape Current Stopwatch Time Display
                StopwatchTimeDisplay(timerType = "Current", configuration = configuration)

                // Landscape Lap Stopwatch Time Display
                AnimatedVisibility(visible = stopwatchStates.isLapStopwatchVisible) {
                    StopwatchTimeDisplay(timerType = "Lap", configuration = configuration)
                }

                // Landscape Stopwatch Button Panel
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {

                    // Landscape Toggle Stopwatch Button
                    GeneralPurposeButton(
                        configuration = configuration,
                        title = "Toggle Stopwatch")

                    // Landscape Lap And Reset Stopwatch Button
                    AnimatedVisibility(visible = stopwatchStates.isLapAndResetStopwatchButtonVisible
                    ) {
                        GeneralPurposeButton(
                            configuration = configuration,
                            title = "Lap And Reset Stopwatch",
                            lapDisplayListState = lapDisplayListState)
                    }
                }
            }

            AnimatedVisibility(visible = stopwatchStates.isLapTimeListVisible) {

                // Right Landscape Stopwatch Screen Panel
                Column(
                    modifier = Modifier
                        .width(dimensions.landscapePanelWidth.dp)
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // Landscape Lap Display List Header
                    LapDisplayListHeader(configuration = configuration)

                    // Landscape Lap Display List
                    LapDisplayList(configuration = configuration, lapDisplayListState = lapDisplayListState) }}}}