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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_colors.StopwatchColors
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_dimensions.LandscapeStopwatchDimensions
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_states.stopwatchStates
import com.timerpro.casualtimer.functionality.casual_timer_screen_functionality.casualTimerScreenFunctionality
import com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_composables.CurrentStopwatchTimeDisplay
import com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_composables.LapAndResetStopwatchButton
import com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_composables.LapDisplayList
import com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_composables.LapDisplayListHeader
import com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_composables.LapStopwatchTimeDisplay
import com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_composables.ToggleStopwatchButton

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LandscapeStopwatchScreen(
    context: Context,
    configuration: Configuration,
    lapDisplayListState: LazyListState) {

    // Logic That Closes Application When Back Button Is Pressed
    BackHandler{ (context as? Activity)?.moveTaskToBack(true)}

    // Move Slide To Stopwatch If Deep Link Is Clicked
    casualTimerScreenFunctionality.moveSliderToStopwatchIfDeepLinkIsClicked(context)

    // Landscape Stopwatch Screen Layout
        Row(
            modifier = Modifier
                .background(color = StopwatchColors().stopwatchScreenBackgroundColor)
                .padding(
                    horizontal = LandscapeStopwatchDimensions(configuration).landscapeStopwatchScreenHorizontalPadding.dp,
                    vertical = LandscapeStopwatchDimensions(configuration).landscapeStopwatchScreenVerticalPadding.dp
                )
                .fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Left Landscape Stopwatch Screen Panel
            Column(
                modifier = Modifier
                    .width(LandscapeStopwatchDimensions(configuration).leftLandscapeStopwatchScreenPanelWidth.dp)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                // Landscape Current Stopwatch Time Display
                CurrentStopwatchTimeDisplay(
                    timeFontSize = LandscapeStopwatchDimensions(configuration).landscapeCurrentStopwatchTimeDisplayFontSize,
                    millisecondsFontSize = LandscapeStopwatchDimensions(configuration).landscapeCurrentStopwatchMillisecondsDisplayFontSize
                )

                // Landscape Lap Stopwatch Time Display
                LapStopwatchTimeDisplay(
                    timeFontSize = LandscapeStopwatchDimensions(configuration).landscapeLapStopwatchTimeDisplayFontSize,
                    millisecondsFontSize = LandscapeStopwatchDimensions(configuration).landscapeLapStopwatchMillisecondsDisplayFontSize,
                    bottomPadding = LandscapeStopwatchDimensions(configuration).leftLandscapeStopwatchScreenPanelComposablePadding
                )

                // Landscape Stopwatch Button Panel
                Row(
                    modifier = Modifier
                        .width(LandscapeStopwatchDimensions(configuration).landscapeStopwatchButtonPanelWidth.dp)
                        .height(LandscapeStopwatchDimensions(configuration).landscapeStopwatchButtonPanelHeight.dp),
                    horizontalArrangement = Arrangement.Center,
                ) {

                    // Landscape Toggle Stopwatch Button
                    ToggleStopwatchButton(
                        context = context,
                        width = LandscapeStopwatchDimensions(configuration).landscapeStopwatchButtonWidth,
                        height = LandscapeStopwatchDimensions(configuration).landscapeStopwatchButtonPanelHeight,
                        endPadding = LandscapeStopwatchDimensions(configuration).landscapeStopwatchButtonPadding,
                        fontSize = LandscapeStopwatchDimensions(configuration).landscapeStopwatchButtonFontSize
                    )

                    // Landscape Lap And Reset Button
                    LapAndResetStopwatchButton(
                        context = context,
                        width = LandscapeStopwatchDimensions(configuration).landscapeStopwatchButtonWidth,
                        height = LandscapeStopwatchDimensions(configuration).landscapeStopwatchButtonPanelHeight,
                        startPadding = LandscapeStopwatchDimensions(configuration).landscapeStopwatchButtonPadding,
                        fontSize = LandscapeStopwatchDimensions(configuration).landscapeStopwatchButtonFontSize,
                        lapDisplayListState = lapDisplayListState
                    )
                }
            }

            AnimatedVisibility(visible = stopwatchStates.isLapTimeListVisible) {

                // Right Landscape Stopwatch Screen Panel
                Column(
                    modifier = Modifier
                        .width(LandscapeStopwatchDimensions(configuration).rightLandscapeStopwatchScreenPanelWidth.dp)
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // Landscape Lap Display List Header
                    LapDisplayListHeader(
                        width = LandscapeStopwatchDimensions(configuration).landscapeLapDisplayListHeaderWidth,
                        height = LandscapeStopwatchDimensions(configuration).landscapeLapDisplayListHeaderHeight,
                        fontSize = LandscapeStopwatchDimensions(configuration).landscapeLapDisplayListFontSize,
                    )

                    // Landscape Lap Display List
                    LapDisplayList(
                        fontSize = LandscapeStopwatchDimensions(configuration).landscapeLapDisplayListFontSize,
                        lapDisplayListState = lapDisplayListState) }}}}