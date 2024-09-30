package com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_layouts

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_dimensions.PortraitStopwatchDimensions
import com.timerpro.casualtimer.functionality.casual_timer_screen_functionality.casualTimerScreenFunctionality
import com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_composables.CurrentStopwatchTimeDisplay
import com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_composables.LapAndResetStopwatchButton
import com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_composables.LapDisplayList
import com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_composables.LapDisplayListHeader
import com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_composables.LapStopwatchTimeDisplay
import com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_composables.ToggleStopwatchButton

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PortraitStopwatchScreen(
    context: Context,
    configuration: Configuration,
    lapDisplayListState: LazyListState) {

    // Logic That Closes Application When Back Button Is Pressed
    BackHandler{ (context as? Activity)?.moveTaskToBack(true)}

    // Move Slide To Stopwatch If Deep Link Is Clicked
    casualTimerScreenFunctionality.moveSliderToStopwatchIfDeepLinkIsClicked(context)

    // Portrait Stopwatch Screen Layout
        Column(
            modifier = Modifier
                .background(color = StopwatchColors().stopwatchScreenBackgroundColor)
                .padding(
                    horizontal = PortraitStopwatchDimensions(configuration).portraitStopwatchScreenHorizontalPadding.dp,
                    vertical = PortraitStopwatchDimensions(configuration).portraitStopwatchScreenVerticalPadding.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

            // Portrait Top Spacer
            Spacer(
                modifier = Modifier
                    .height(PortraitStopwatchDimensions(configuration).portraitTopSpacerHeight.dp))

            // Portrait Current Stopwatch Time Display
            CurrentStopwatchTimeDisplay(
                timeFontSize = PortraitStopwatchDimensions(configuration).portraitCurrentStopwatchTimeDisplayFontSize,
                millisecondsFontSize = PortraitStopwatchDimensions(configuration).portraitCurrentStopwatchMillisecondsDisplayFontSize)

            // Portrait Lap Stopwatch Time Display
            LapStopwatchTimeDisplay(
                timeFontSize = PortraitStopwatchDimensions(configuration).portraitLapStopwatchTimeDisplayFontSize,
                millisecondsFontSize = PortraitStopwatchDimensions(configuration).portraitLapStopwatchMillisecondsDisplayFontSize,
                bottomPadding = PortraitStopwatchDimensions(configuration).portraitStopwatchComposablePadding)

            Column(
                modifier = Modifier
                    .padding(bottom = PortraitStopwatchDimensions(configuration).portraitStopwatchComposablePadding.dp)
                    .width(PortraitStopwatchDimensions(configuration).portraitLapDisplayListContainerWidth.dp)
                    .height(PortraitStopwatchDimensions(configuration).portraitLapDisplayListContainerHeight.dp)) {
                LapDisplayListHeader(
                    width = PortraitStopwatchDimensions(configuration).portraitLapDisplayListHeaderWidth,
                    height = PortraitStopwatchDimensions(configuration).portraitLapDisplayListHeaderHeight,
                    fontSize = PortraitStopwatchDimensions(configuration).portraitLapDisplayListFontSize,)

                LapDisplayList(
                    fontSize = PortraitStopwatchDimensions(configuration).portraitLapDisplayListFontSize,
                    lapDisplayListState = lapDisplayListState) }

            // Portrait Button Panel
            Row(
                modifier = Modifier
                    .width(PortraitStopwatchDimensions(configuration).portraitStopwatchButtonPanelWidth.dp)
                    .height(PortraitStopwatchDimensions(configuration).portraitStopwatchButtonPanelHeight.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {

                // Portrait Toggle Stopwatch Button
                ToggleStopwatchButton(
                    context = context,
                    width = PortraitStopwatchDimensions(configuration).portraitStopwatchButtonWidth,
                    height = PortraitStopwatchDimensions(configuration).portraitStopwatchButtonHeight,
                    endPadding = PortraitStopwatchDimensions(configuration).portraitStopwatchButtonPadding,
                    fontSize = PortraitStopwatchDimensions(configuration).portraitStopwatchButtonFontSize)

                // Portrait Lap And Reset Stopwatch Button
                LapAndResetStopwatchButton(
                    context = context,
                    width = PortraitStopwatchDimensions(configuration).portraitStopwatchButtonWidth,
                    height = PortraitStopwatchDimensions(configuration).portraitStopwatchButtonHeight,
                    startPadding = PortraitStopwatchDimensions(configuration).portraitStopwatchButtonPadding,
                    fontSize = PortraitStopwatchDimensions(configuration).portraitStopwatchButtonFontSize,
                    lapDisplayListState = lapDisplayListState) }}}