package com.timerpro.casualtimer.data.timer_data.timer_dimensions.alarm_sound_selection_dialog_dimensions

import android.content.res.Configuration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions

class AlarmSoundSelectionDialogDimensions(configuration: Configuration, dimensions: ScreenDimensions = ScreenDimensions(configuration)) {

    // Alarm Sound Selection Dialog Dimensions
    val dialogSize = dimensions.screenSize * 0.28.dp

    // Alarm Sound Selection Dialog Padding
    val horizontalPadding = dimensions.screenSize * 0.03
    val verticalPadding = dimensions.screenSize * 0.005

    // Alarm Sound Selection Dialog Font Dimensions
    val headerFontSize = dimensions.screenSize * 0.013.sp
    val alarmSoundNameFontSize = dimensions.screenSize * 0.015.sp

    // Alarm Sound Selection List Spacing
    val listSpacing = dimensions.screenSize * 0.011
}