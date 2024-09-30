package com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_composables

import android.content.Context
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_colors.StopwatchColors
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_states.stopwatchStates
import com.timerpro.casualtimer.functionality.stopwatch_functionality.StopwatchButtonStateFunctionality
import com.timerpro.casualtimer.functionality.stopwatch_functionality.stopwatchCurrentTimeFunctionality

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ToggleStopwatchButton(
    context: Context,
    width: Int,
    height: Int,
    endPadding: Int,
    fontSize: Int
) {

    // Manage Toggle Stopwatch Button Text
    StopwatchButtonStateFunctionality().manageToggleStopwatchButtonText()

    Card(
        modifier = Modifier
            .padding(end = endPadding.dp)
            .combinedClickable(

                // Manage Toggle Stopwatch Button On Click States
                onClick = {stopwatchCurrentTimeFunctionality.manageToggleStopwatchButtonOnClickStates(context) },
                onDoubleClick = {})

            .width(width.dp)
            .height(height.dp),

        // Conditional That Determines Toggle Stopwatch Button Background Color
        colors = CardDefaults.cardColors(containerColor = animateColorAsState(targetValue =

            // Changes Toggle Stopwatch Button Background Color To Blue
            when {!stopwatchStates.isStopwatchActive
            -> StopwatchColors().startStopwatchButtonBackgroundColor

                // Changes Toggle Stopwatch Button Background Color To Red
                else -> {StopwatchColors().pauseStopwatchButtonBackgroundColor}

            }, animationSpec = keyframes { durationMillis = 150 }).value),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(10.dp)) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center) {

            // Toggle Stopwatch Button Text
            Text(
                text = stopwatchStates.toggleStopwatchButtonText,
                color =  StopwatchColors().stopwatchButtonFontColor,
                fontSize = fontSize.sp,
                fontWeight = FontWeight.SemiBold) }}}