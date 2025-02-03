package com.timerpro.casualtimer.data.timer_data.timer_dimensions.alarm_sound_selection_dialog_dimensions

import android.content.res.Configuration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions

class AlarmSoundSelectionDialogDimensions(configuration: Configuration, dimensions: ScreenDimensions = ScreenDimensions(configuration)) {

    // Alarm Sound Selection Dialog Font Dimensions
    val headerFontSize = dimensions.screenSize * 0.015.sp
    val alarmSoundNameFontSize = dimensions.screenSize * 0.015.sp

    val height = dimensions.screenSize * 0.5.dp

    val cornerRadius = dimensions.screenSize * 0.01.dp

    // Alarm Sound Selection Dialog Item Dimensions
    val itemHeight = dimensions.screenSize * 0.06.dp
    val itemSpacing = dimensions.screenSize * 0.01.dp
    val itemHorizontalPadding = dimensions.screenSize * 0.014.dp

    val dividerHeight = dimensions.screenSize * 0.0005.dp

    // Alarm Sound Selection Dialog Button Panel Dimensions
    val buttonPanelDividerWidth = dimensions.screenSize * 0.001.dp
    val buttonPanelDividerHeight = dimensions.screenSize * 0.01.dp
}