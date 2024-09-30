package com.timerpro.casualtimer.data.timer_data.timer_dimensions.edit_preset_time_dialog_dimensions

import android.content.res.Configuration
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions

class PortraitEditPresetTimeDialogDimensions(configuration: Configuration) {

    // Portrait Edit Preset Time Dialog Dimensions
    var portraitEditPresetTimeDialogWidth by mutableIntStateOf((ScreenDimensions(configuration).screenWidth * 0.85).toInt())
    var unexpandedPortraitEditPresetTimeDialogHeight by mutableIntStateOf((portraitEditPresetTimeDialogWidth * 0.20).toInt())
    var expandedPortraitEditPresetTimeDialogHeight by mutableIntStateOf((portraitEditPresetTimeDialogWidth * 0.99).toInt())

    // Portrait Edit Preset Time Dialog Text Field Dimensions
    var portraitEditPresetTimeDialogTextFieldSize by mutableIntStateOf((portraitEditPresetTimeDialogWidth * 0.25).toInt())
    var portraitEditPresetTimeDialogTextFieldFontSize by mutableIntStateOf(((portraitEditPresetTimeDialogTextFieldSize * 0.53).toInt()))
    var portraitEditPresetTimeDialogTextFieldPanelVerticalSpacing by mutableIntStateOf(((expandedPortraitEditPresetTimeDialogHeight * 0.01).toInt()))

    // Portrait Edit Preset Time Dialog Increment & Decrement Button Dimensions
    var portraitIncrementAndDecrementButtonSize by mutableIntStateOf(((expandedPortraitEditPresetTimeDialogHeight * 0.08).toInt()))
    var portraitIncrementAndDecrementIconSize by mutableIntStateOf(((portraitIncrementAndDecrementButtonSize * 0.68).toInt()))

    // Portrait Edit Preset Time Name Text Field Dimensions
    var portraitEditPresetTimeNameTextFieldWidth by mutableIntStateOf(((portraitEditPresetTimeDialogWidth) * 0.75).toInt())
    var portraitEditPresetTimeNameTextFieldHeight by mutableIntStateOf(((portraitEditPresetTimeNameTextFieldWidth * 0.20).toInt()))
    var portraitEditPresetTimeNameTextFieldFontSize by mutableIntStateOf((portraitEditPresetTimeNameTextFieldHeight * 0.27).toInt())

    // Portrait Edit Preset Time Button Dimensions
    var portraitEditPresetTimeDialogButtonWidth by mutableIntStateOf((portraitEditPresetTimeDialogWidth * 0.35).toInt())
    var portraitEditPresetTimeDialogButtonHeight by mutableIntStateOf((portraitEditPresetTimeDialogButtonWidth * 0.35).toInt())
    var portraitEditPresetTimeButtonFontSize by mutableIntStateOf((portraitEditPresetTimeDialogButtonHeight * 0.38).toInt())

}