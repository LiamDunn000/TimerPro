package com.timerpro.casualtimer.data.timer_data.timer_dimensions.alarm_sound_selection_dialog_dimensions

import android.content.res.Configuration
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions

class PortraitAlarmSoundSelectionDialogDimensions(configuration: Configuration) {

    // Portrait Alarm Sound Selection Dialog Dimensions
    var portraitAlarmSoundSelectionDialogWidth by mutableIntStateOf((ScreenDimensions(configuration).screenWidth * 0.85).toInt())
    var portraitAlarmSoundSelectionDialogHeight by mutableIntStateOf((portraitAlarmSoundSelectionDialogWidth * 0.99).toInt())

    // Portrait Alarm Sound Selection Dialog Padding
    var portraitAlarmSoundSelectionDialogHorizontalPadding by mutableIntStateOf((portraitAlarmSoundSelectionDialogWidth * 0.09).toInt())
    var portraitAlarmSoundSelectionDialogVerticalPadding by mutableIntStateOf((portraitAlarmSoundSelectionDialogHeight * 0.01).toInt())

    // Portrait Alarm Sound Selection Dialog Font Dimensions
    var portraitAlarmSoundSelectionDialogHeaderFontSize by mutableIntStateOf((portraitAlarmSoundSelectionDialogWidth * 0.042).toInt())
    var portraitAlarmSoundNameFontSize by mutableIntStateOf((portraitAlarmSoundSelectionDialogWidth * 0.045).toInt())

    // Portrait Alarm Sound Selection Dialog Radio Button Dimensions
    var portraitAlarmSoundSelectionRadioButtonSize by mutableIntStateOf((ScreenDimensions(configuration).screenWidth * 0.043).toInt())
    var portraitAlarmSoundSelectionRadioButtonBorderWidth by mutableIntStateOf((portraitAlarmSoundSelectionRadioButtonSize * 0.13).toInt())

    // Portrait Alarm Sound Selection List Spacing
    var portraitAlarmSoundSelectionListSpacing by mutableIntStateOf((portraitAlarmSoundSelectionDialogHeight * 0.05).toInt())

    // Portrait Close Alarm Sound Selection Dialog Button Dimensions
    var portraitCloseAlarmSoundSelectionDialogButtonWidth by mutableIntStateOf((portraitAlarmSoundSelectionDialogWidth * 0.40).toInt())
    var portraitCloseAlarmSoundSelectionDialogButtonHeight by mutableIntStateOf((portraitCloseAlarmSoundSelectionDialogButtonWidth * 0.28).toInt())
    var portraitCloseAlarmSoundSelectionDialogButtonFontSize by mutableIntStateOf((portraitCloseAlarmSoundSelectionDialogButtonHeight * 0.38).toInt())
}