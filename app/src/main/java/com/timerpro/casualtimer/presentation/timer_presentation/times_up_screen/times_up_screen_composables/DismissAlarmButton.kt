package com.timerpro.casualtimer.presentation.timer_presentation.times_up_screen.times_up_screen_composables

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

@Composable
fun DismissAlarmButton(
    onClick: () -> Unit,
    width: Int,
    height: Int,
    fontSize: Int) {

    // Dismiss Alarm Button Layout
    Button(
        modifier = Modifier
            .width(width = width.dp)
            .height(height = height.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = timerColors.dismissAlarmButtonBackgroundColor
        ),

        // Dismiss Alarm
        onClick = { onClick() },
        shape = RoundedCornerShape(5.dp),
        elevation = ButtonDefaults.buttonElevation(10.dp)) {

        // Dismiss Alarm Button Text
        Text(
            text = "Dismiss",
            fontSize = fontSize.sp,
            fontWeight = FontWeight.SemiBold) }
}