package com.timerpro.casualtimer.data.timer_data.timer_dimensions.time_selection_screen_dimensions

import android.content.res.Configuration
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions

class PortraitTimeSelectionScreenDimensions(configuration: Configuration) {

    // Portrait Time Selection Screen Padding
    var portraitTimeSelectionScreensHorizontalPadding by mutableIntStateOf(((ScreenDimensions(configuration).screenHeight * 0.030).toInt()))
    var portraitTimeSelectionScreensVerticalPadding by mutableIntStateOf(((ScreenDimensions(configuration).screenHeight * 0.030).toInt()))

    // Portrait Time Selection Screen Composable Padding
    var portraitTimeSelectionScreensComposablePadding by mutableIntStateOf(((ScreenDimensions(configuration).screenHeight * 0.035).toInt()))

    // Portrait Time Selection Screen Text Field Panel Dimensions
    var portraitTimeSelectionScreenTextFieldPanelWidth by mutableIntStateOf((ScreenDimensions(configuration).screenWidth))
    var portraitTimeSelectionScreenTextFieldPanelHeight by mutableIntStateOf(((portraitTimeSelectionScreenTextFieldPanelWidth * 0.60).toInt()))
    var portraitTimeSelectionScreenTextFieldPanelVerticalSpacing by mutableIntStateOf(((portraitTimeSelectionScreenTextFieldPanelHeight * 0.05).toInt()))

    // Portrait Time Selection Screen Text Field Dimensions
    var portraitTimeSelectionTextFieldSize by mutableIntStateOf(((portraitTimeSelectionScreenTextFieldPanelHeight * 0.45).toInt()))
    var portraitTimeSelectionTextFieldFontSize by mutableIntStateOf((portraitTimeSelectionTextFieldSize * 0.50).toInt())

    // Portrait Time Selection Screen Top App Bar Button Size
    var portraitTimeSelectionScreenTopAppBarButtonSize by mutableIntStateOf(((ScreenDimensions(configuration).screenWidth * 0.035).toInt()))

    // Portrait Increment & Decrement Button Dimensions
    var portraitIncrementAndDecrementButtonSize by mutableIntStateOf(((portraitTimeSelectionScreenTextFieldPanelHeight * 0.15).toInt()))
    var portraitIncrementAndDecrementIconSize by mutableIntStateOf(((portraitIncrementAndDecrementButtonSize * 0.75).toInt()))

    // Portrait Time Selection Button Panel Dimensions
    var portraitTimeSelectionScreenButtonPanelWidth by mutableIntStateOf((ScreenDimensions(configuration).screenWidth))
    var portraitTimeSelectionScreenButtonPanelHeight by mutableIntStateOf((portraitTimeSelectionScreenButtonPanelWidth * 0.13).toInt())

    // Portrait Start Timer Button Dimensions
    var portraitStartTimerButtonWidth by mutableIntStateOf((portraitTimeSelectionScreenButtonPanelWidth * 0.32).toInt())
    var portraitStartTimerButtonHeight by mutableIntStateOf(portraitTimeSelectionScreenButtonPanelHeight)
    var portraitStartTimerButtonFontSize by mutableIntStateOf((portraitStartTimerButtonHeight * 0.5).toInt())

    // Portrait Preset Time Panel Dimensions
    var portraitPresetTimeFontSize by mutableIntStateOf((ScreenDimensions(configuration).screenWidth * 0.06).toInt())
    var portraitPresetTimeNameFontSize by mutableIntStateOf((portraitPresetTimeFontSize * 0.60).toInt())

}