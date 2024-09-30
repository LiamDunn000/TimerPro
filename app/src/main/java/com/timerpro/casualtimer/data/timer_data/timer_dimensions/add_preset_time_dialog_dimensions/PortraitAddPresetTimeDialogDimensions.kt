package com.timerpro.casualtimer.data.timer_data.timer_dimensions.add_preset_time_dialog_dimensions

import android.content.res.Configuration
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions

class PortraitAddPresetTimeDialogDimensions(configuration: Configuration) {

    // Portrait Add Preset Time Dialog Dimensions
    var portraitAddPresetTimeDialogWidth by mutableIntStateOf((ScreenDimensions(configuration).screenWidth * 0.85).toInt())
    var portraitAddPresetTimeDialogHeight by mutableIntStateOf((portraitAddPresetTimeDialogWidth * 0.99).toInt())

    // Portrait Add Preset Time Dialog Text Field Dimensions
    var portraitAddPresetTimeDialogTextFieldSize by mutableIntStateOf((portraitAddPresetTimeDialogWidth * 0.25).toInt())
    var portraitAddPresetTimeDialogTextFieldFontSize by mutableIntStateOf(((portraitAddPresetTimeDialogTextFieldSize * 0.53).toInt()))
    var portraitAddPresetTimeDialogTextFieldPanelVerticalSpacing by mutableIntStateOf(((portraitAddPresetTimeDialogHeight * 0.01).toInt()))

    // Portrait Add Preset Time Dialog Increment & Decrement Button Dimensions
    var portraitIncrementAndDecrementButtonSize by mutableIntStateOf(((portraitAddPresetTimeDialogHeight * 0.08).toInt()))
    var portraitIncrementAndDecrementIconSize by mutableIntStateOf(((portraitIncrementAndDecrementButtonSize * 0.68).toInt()))

    // Portrait Preset Time Name Text Field Dimensions
    var portraitPresetTimeNameTextFieldWidth by mutableIntStateOf(((portraitAddPresetTimeDialogWidth) * 0.75).toInt())
    var portraitPresetTimeNameTextFieldHeight by mutableIntStateOf(((portraitPresetTimeNameTextFieldWidth * 0.20).toInt()))
    var portraitPresetTimeNameTextFieldFontSize by mutableIntStateOf((portraitPresetTimeNameTextFieldHeight * 0.27).toInt())

    // Portrait Save Preset Time Button Dimensions
    var portraitSavePresetTimeDialogButtonWidth by mutableIntStateOf((portraitAddPresetTimeDialogWidth * 0.35).toInt())
    var portraitSavePresetTimeDialogButtonHeight by mutableIntStateOf((portraitSavePresetTimeDialogButtonWidth * 0.35).toInt())
    var portraitSavePresetTimeButtonFontSize by mutableIntStateOf((portraitSavePresetTimeDialogButtonHeight * 0.38).toInt())

}