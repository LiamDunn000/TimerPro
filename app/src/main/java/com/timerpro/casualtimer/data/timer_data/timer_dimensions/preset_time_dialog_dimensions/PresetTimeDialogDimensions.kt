package com.timerpro.casualtimer.data.timer_data.timer_dimensions.preset_time_dialog_dimensions

import android.content.res.Configuration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions

class PresetTimeDialogDimensions(
    configuration: Configuration,
    dimensions: ScreenDimensions = ScreenDimensions(configuration)) {

    val dialogSize = dimensions.screenSize * 0.28.dp
    val horizontalPadding = dimensions.screenSize * 0.03.dp
    val verticalPadding = dimensions.screenSize * 0.02.dp
    val cornerRadius = 1

    // Preset Time Dialog Title Text Field Dimensions
    val titleTextFieldHeight = dimensions.screenSize * 0.045.dp
    val titleTextFieldFontSize = dimensions.screenSize * 0.013.sp
}