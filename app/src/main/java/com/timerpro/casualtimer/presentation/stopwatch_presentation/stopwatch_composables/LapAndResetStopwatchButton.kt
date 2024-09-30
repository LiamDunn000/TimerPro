package com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_composables

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_colors.StopwatchColors
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_states.stopwatchStates
import com.timerpro.casualtimer.functionality.stopwatch_functionality.StopwatchButtonStateFunctionality
import com.timerpro.casualtimer.functionality.stopwatch_functionality.stopwatchLapTimeFunctionality
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LapAndResetStopwatchButton(
    context: Context,
    width: Int,
    height: Int,
    startPadding: Int,
    fontSize: Int,
    lapDisplayListState: LazyListState) {

    // Manage Lap and Reset Stopwatch Button Text
    StopwatchButtonStateFunctionality().manageLapAndResetStopwatchButtonText()

    val scrollToItemCoroutineScope = rememberCoroutineScope()

    // Toggle Stopwatch Button
    AnimatedVisibility(visible = stopwatchStates.isLapAndResetStopwatchButtonVisible) {
        Card(
            modifier = Modifier
                .padding(start = startPadding.dp)
                .combinedClickable(

                    // Manage Lap and Reset Stopwatch Button On Click States
                    onClick = {
                        stopwatchLapTimeFunctionality.manageLapAndResetButtonOnClickStates(context = context)
                        scrollToItemCoroutineScope.launch {
                            when {
                                stopwatchStates.laps.size > 0
                                -> lapDisplayListState.scrollToItem(0) }}},
                    onDoubleClick = { })

                .width(width.dp)
                .height(height.dp),

            // Conditional That Determines Lap And Reset Stopwatch Button Color
            colors = CardDefaults.cardColors(
                containerColor = animateColorAsState(
                    targetValue =

                    // Changes Lap and Reset Stopwatch Button Background Color To Blue
                    when {stopwatchStates.isStopwatchActive && stopwatchStates.laps.size != 99
                        -> { StopwatchColors().lapStopwatchButtonBackgroundColor }

                        // Changes Lap and Reset Stopwatch Button Background Color To Red
                        else -> {
                            StopwatchColors().resetStopwatchButtonBackgroundColor
                        }
                    }, animationSpec = keyframes { durationMillis = 150 }).value),

            shape = RoundedCornerShape(5.dp),
            elevation = CardDefaults.cardElevation(10.dp)) {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                // Lap and Reset Stopwatch Button Text
                Text(
                    text = stopwatchStates.lapAndResetStopwatchButtonText,
                    color = StopwatchColors().stopwatchButtonFontColor,
                    fontSize = fontSize.sp,
                    fontWeight = FontWeight.SemiBold) }}}}