package com.timerpro.casualtimer.data.timer_data.timer_dimensions.edit_preset_time_dialog_dimensions

import android.content.res.Configuration
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions

class LandscapeEditPresetTimeDialogDimensions(configuration: Configuration) {

    // Landscape Edit Preset Time Dialog Dimensions
    var landscapeEditPresetTimeDialogWidth by mutableIntStateOf((ScreenDimensions(configuration).screenWidth * 0.85).toInt())
    var unexpandedLandscapeEditPresetTimeDialogHeight by mutableIntStateOf((landscapeEditPresetTimeDialogWidth * 0.10).toInt())
    var expandedLandscapeEditPresetTimeDialogHeight by mutableIntStateOf((landscapeEditPresetTimeDialogWidth * 0.50).toInt())

    // Landscape Edit Preset Time Dialog Text Field Dimensions
    var landscapeEditPresetTimeDialogTextFieldSize by mutableIntStateOf((landscapeEditPresetTimeDialogWidth * 0.13).toInt())
    var landscapeEditPresetTimeDialogTextFieldFontSize by mutableIntStateOf(((landscapeEditPresetTimeDialogTextFieldSize * 0.50).toInt()))
    var landscapeEditPresetTimeDialogTextFieldPanelVerticalSpacing by mutableIntStateOf(((expandedLandscapeEditPresetTimeDialogHeight * 0.01).toInt()))

    // Landscape Edit Preset Time Dialog Increment & Decrement Button Dimensions
    var landscapeIncrementAndDecrementButtonSize by mutableIntStateOf(((expandedLandscapeEditPresetTimeDialogHeight * 0.10).toInt()))
    var landscapeIncrementAndDecrementIconSize by mutableIntStateOf(((landscapeIncrementAndDecrementButtonSize * 0.70).toInt()))

    // Landscape Edit Preset Time Name Text Field Dimensions
    var landscapeEditPresetTimeNameTextFieldWidth by mutableIntStateOf(((landscapeEditPresetTimeDialogWidth) * 0.33).toInt())
    var landscapeEditPresetTimeNameTextFieldHeight by mutableIntStateOf(((landscapeEditPresetTimeNameTextFieldWidth * 0.24).toInt()))
    var landscapeEditPresetTimeNameTextFieldFontSize by mutableIntStateOf((landscapeEditPresetTimeNameTextFieldHeight * 0.30).toInt())

    // Landscape Edit Preset Time Dialog Button Dimensions
    var landscapeEditPresetTimeDialogButtonWidth by mutableIntStateOf((landscapeEditPresetTimeDialogWidth * 0.15).toInt())
    var landscapeEditPresetTimeDialogButtonHeight by mutableIntStateOf((landscapeEditPresetTimeDialogButtonWidth * 0.35).toInt())
    var landscapeEditPresetTimeButtonFontSize by mutableIntStateOf((landscapeEditPresetTimeDialogButtonHeight * 0.38).toInt())

}