package com.timerpro.casualtimer.data.timer_data.timer_dimensions.add_preset_time_dialog_dimensions

import android.content.res.Configuration
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions

class LandscapeAddPresetTimeDialogDimensions(configuration: Configuration) {

    // Portrait Add Preset Time Dialog Dimensions
    var landscapeAddPresetTimeDialogWidth by mutableIntStateOf((ScreenDimensions(configuration).screenWidth * 0.85).toInt())
    var landscapeAddPresetTimeDialogHeight by mutableIntStateOf((landscapeAddPresetTimeDialogWidth * 0.50).toInt())

    // Landscape Time Selection Screen Text Field Dimensions
    var landscapeAddPresetTimeDialogTextFieldSize by mutableIntStateOf((landscapeAddPresetTimeDialogWidth * 0.13).toInt())
    var landscapeAddPresetTimeDialogTextFieldFontSize by mutableIntStateOf(((landscapeAddPresetTimeDialogTextFieldSize * 0.50).toInt()))
    var landscapeAddPresetTimeDialogTextFieldPanelVerticalSpacing by mutableIntStateOf(((landscapeAddPresetTimeDialogHeight * 0.01).toInt()))

    // Landscape Add Preset Time Dialog Increment & Decrement Button Dimensions
    var landscapeIncrementAndDecrementButtonSize by mutableIntStateOf(((landscapeAddPresetTimeDialogHeight * 0.10).toInt()))
    var landscapeIncrementAndDecrementIconSize by mutableIntStateOf(((landscapeIncrementAndDecrementButtonSize * 0.70).toInt()))

    // Landscape Preset Time Name Text Field Dimensions
    var landscapePresetTimeNameTextFieldWidth by mutableIntStateOf(((landscapeAddPresetTimeDialogWidth) * 0.33).toInt())
    var landscapePresetTimeNameTextFieldHeight by mutableIntStateOf(((landscapePresetTimeNameTextFieldWidth * 0.24).toInt()))
    var landscapePresetTimeNameTextFieldFontSize by mutableIntStateOf((landscapePresetTimeNameTextFieldHeight * 0.30).toInt())

    // Landscape Save Preset Time Button Dimensions
    var landscapeSavePresetTimeDialogButtonWidth by mutableIntStateOf((landscapeAddPresetTimeDialogWidth * 0.15).toInt())
    var landscapeSavePresetTimeDialogButtonHeight by mutableIntStateOf((landscapeSavePresetTimeDialogButtonWidth * 0.35).toInt())
    var landscapeSavePresetTimeButtonFontSize by mutableIntStateOf((landscapeSavePresetTimeDialogButtonHeight * 0.38).toInt())

}