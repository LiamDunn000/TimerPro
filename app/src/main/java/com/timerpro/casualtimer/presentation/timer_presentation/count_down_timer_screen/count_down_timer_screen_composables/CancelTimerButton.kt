package com.timerpro.casualtimer.presentation.timer_presentation.count_down_timer_screen.count_down_timer_screen_composables

import android.content.Context
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.timerpro.casualtimer.data.timer_data.timer_colors.timerColors
import com.timerpro.casualtimer.functionality.timer_functionality.timerStateFunctionality

@Composable
fun CancelTimerButton(
    context: Context,
    width: Int,
    height: Int,
    fontSize: Int) {

    // Cancel Timer Button Layout
    Button(
        modifier = Modifier
            .width(width = width.dp)
            .height(height = height.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = timerColors.pauseAndCancelTimerButtonBackgroundColor
        ),
        onClick = { timerStateFunctionality.cancelTimer(context = context) },

        shape = RoundedCornerShape(5.dp),
        elevation = ButtonDefaults.buttonElevation(10.dp)) {

        // Cancel Timer Button Text
        Text(
            text = "Cancel",
            fontSize = fontSize.sp,
            fontWeight = FontWeight.SemiBold) }}