package com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_composables

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.timerpro.casualtimer.data.timer_data.timer_colors.timerColors
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.timer_functionality.timerButtonStateFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.timerStateFunctionality

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StartTimerButton(
    context: Context,
    width: Int,
    height: Int,
    fontSize: Int) {

    timerButtonStateFunctionality.manageStartTimerButtonEnabledState()

    // Start Timer Button Layout
    Card(
        modifier = Modifier
            .width(width = width.dp)
            .height(height = height.dp)
            .combinedClickable(

                // Start Timer
                onClick = { timerStateFunctionality.startTimer(context = context) },
                onDoubleClick = {},
                enabled = timerStates.isStartTimerButtonEnabled),

        colors = CardDefaults.cardColors(containerColor = animateColorAsState(targetValue =

        // Conditional That Determines Start Timer Button Background Color
        when {

            // Changes Start Timer Button Background Color When Enabled
            timerStates.isStartTimerButtonEnabled -> timerColors.enabledStartTimerButtonBackgroundColor

            // Changes Start Timer Button Background Color When Disabled
            else -> { timerColors.disabledStartTimerButtonBackgroundColor}

        }, animationSpec = keyframes { durationMillis = 150 }).value),

        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(10.dp)) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center) {

            // Start Timer Button Text
            Text(
                text = "Start",
                color = animateColorAsState(targetValue =

                // Conditional That Determines Start Timer Button Font Color
                when {

                    // Changes Start Timer Button Font Color When Enabled
                    timerStates.isStartTimerButtonEnabled -> timerColors.enabledStartTimerButtonFontColor

                    // Changes Start Timer Button Background Color When Disabled
                    else -> { timerColors.disabledStartTimerButtonFontColor}

                }, animationSpec = keyframes { durationMillis = 150 }).value,
                fontSize = fontSize.sp,
                fontWeight = FontWeight.SemiBold
            )
        } }}