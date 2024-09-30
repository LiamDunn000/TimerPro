package com.timerpro.casualtimer.presentation.timer_presentation.count_down_timer_screen.count_down_timer_screen_composables

import android.content.Context
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_colors.StopwatchColors
import com.timerpro.casualtimer.data.timer_data.timer_colors.TimerColors
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.timer_functionality.timerButtonStateFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.timerStateFunctionality

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ToggleTimerButton(
    context: Context,
    width: Int,
    height: Int,
    fontSize: Int) {

    // Manage Toggle Timer Button Text State
    timerButtonStateFunctionality.manageToggleTimerButtonTextState()

    // Toggle Timer Button Layout
    Card(
        modifier = Modifier
            .width(width = width.dp)
            .height(height = height.dp)
            .combinedClickable(
                onClick = { timerStateFunctionality.toggleTimer(context = context) },
                onDoubleClick = {}),

        // Conditional That Determines Toggle Stopwatch Button Background Color
        colors = CardDefaults.cardColors(containerColor = animateColorAsState(targetValue =

        // Changes Toggle Timer Button Background Color To Blue
        when {!timerStates.isTimerActive
        -> TimerColors().resumeTimerButtonBackgroundColor

            // Changes Toggle Stopwatch Button Background Color To Red
            else -> {
                StopwatchColors().pauseStopwatchButtonBackgroundColor}

        }, animationSpec = keyframes { durationMillis = 150 }).value),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(10.dp)) {

        // Toggle Timer Button Text
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = timerStates.toggleTimerButtonText,
                color = Color.White,
                fontSize = fontSize.sp,
                fontWeight = FontWeight.SemiBold
            )
        } }
}