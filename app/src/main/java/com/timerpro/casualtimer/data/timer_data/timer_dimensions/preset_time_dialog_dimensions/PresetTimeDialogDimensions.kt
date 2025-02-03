package com.timerpro.casualtimer.data.timer_data.timer_dimensions.preset_time_dialog_dimensions

import android.content.res.Configuration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions

class PresetTimeDialogDimensions(
    configuration: Configuration,
    dimen: ScreenDimensions = ScreenDimensions(configuration)) {

    val dialogSize = dimen.screenSize * 0.28.dp
    val horizontalPadding = dimen.screenSize * 0.03.dp
    val verticalPadding = dimen.screenSize * 0.02.dp
    val cornerRadius = dimen.screenSize * 0.007.dp

    // Preset Time Dialog Title Text Field Dimensions
    val titleTextFieldHeight = dimen.screenSize * 0.045.dp
    val titleTextFieldFontSize = dimen.screenSize * 0.013.sp
}