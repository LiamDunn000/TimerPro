package com.timerpro.casualtimer.presentation.timer_presentation.edit_preset_time_dialog.edit_preset_time_dialog_composables

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
import com.timerpro.casualtimer.functionality.casual_timer_screen_functionality.casualTimerScreenFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.presetTimeFunctionality

@Composable
fun UpdatePresetTimeButton(
    context: Context,
    onClick: () -> Unit,
    width: Int,
    height: Int,
    fontSize: Int) {

    // Update Preset Time Button
    Button(

        // Update Preset Time & Reset Add Preset Time Dialog State
        onClick = {
            onClick()
            casualTimerScreenFunctionality.vibrateOnButtonClick(context = context)
            presetTimeFunctionality.resetAddPresetTimeDialogState() },

        modifier = Modifier
            .width(width = width.dp)
            .height(height = height.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = timerColors.savePresetTimeButtonBackgroundColor
        ),
        shape = RoundedCornerShape(5.dp),
        elevation = ButtonDefaults.buttonElevation(10.dp)
    ) {

        // Update Preset Time Button Text
        Text(
            text = "Update",
            fontSize = fontSize.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}