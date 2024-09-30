package com.timerpro.casualtimer.data.timer_data.timer_dimensions.time_selection_screen_dimensions

import android.content.res.Configuration
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions

class LandscapeTimeSelectionScreenDimensions(configuration: Configuration) {

    // Landscape Time Selection Screen Padding
    var landscapeTimeSelectionScreensHorizontalPadding by mutableIntStateOf(((ScreenDimensions(configuration).screenWidth * 0.030).toInt()))
    var landscapeTimeSelectionScreensVerticalPadding by mutableIntStateOf(((ScreenDimensions(configuration).screenHeight * 0.099).toInt()))

    // Landscape Time Selection Screen Panel Dimensions
    var leftLandscapeTimeSelectionScreenPanelWidth by mutableIntStateOf((ScreenDimensions(configuration).screenWidth / 2))
    var rightLandscapeTimeSelectionScreenPanelWidth by mutableIntStateOf((ScreenDimensions(configuration).screenWidth / 2))
    //var leftLandscapeStopwatchScreenPanelComposablePadding by mutableIntStateOf((leftLandscapeStopwatchScreenPanelWidth * 0.04).toInt())

    // Landscape Time Selection Screen Text Field Panel Dimensions
    var landscapeTimeSelectionScreenTextFieldPanelWidth by mutableIntStateOf((leftLandscapeTimeSelectionScreenPanelWidth * 0.80).toInt())
    var landscapeTimeSelectionScreenTextFieldPanelHeight by mutableIntStateOf(((landscapeTimeSelectionScreenTextFieldPanelWidth * 0.60).toInt()))
    var landscapeTimeSelectionScreenTextFieldPanelVerticalSpacing by mutableIntStateOf(((landscapeTimeSelectionScreenTextFieldPanelHeight * 0.05).toInt()))

    // Landscape Time Selection Screen Text Field Dimensions
    var landscapeTimeSelectionTextFieldSize by mutableIntStateOf(((landscapeTimeSelectionScreenTextFieldPanelWidth * 0.30).toInt()))
    var landscapeTimeSelectionTextFieldFontSize by mutableIntStateOf((landscapeTimeSelectionTextFieldSize * 0.50).toInt())

    // Landscape Time Selection Screen Top App Bar Button Size
    var landscapeTimeSelectionScreenTopAppBarButtonSize by mutableIntStateOf(((ScreenDimensions(configuration).screenWidth * 0.020).toInt()))

    // Portrait Increment & Decrement Button Dimensions
    var landscapeIncrementAndDecrementButtonSize by mutableIntStateOf(((landscapeTimeSelectionScreenTextFieldPanelHeight * 0.16).toInt()))
    var landscapeIncrementAndDecrementIconSize by mutableIntStateOf(((landscapeIncrementAndDecrementButtonSize * 0.76).toInt()))

    // Landscape Time Selection Screen Button Panel Dimensions
    var landscapeTimeSelectionScreenButtonPanelWidth by mutableIntStateOf((leftLandscapeTimeSelectionScreenPanelWidth))
    var landscapeTimeSelectionScreenButtonPanelHeight by mutableIntStateOf((landscapeTimeSelectionScreenButtonPanelWidth * 0.12).toInt())

    // Landscape Start Timer Button Dimensions
    var landscapeStartTimerButtonWidth by mutableIntStateOf((landscapeTimeSelectionScreenButtonPanelWidth * 0.32).toInt())
    var landscapeStartTimerButtonHeight by mutableIntStateOf(landscapeTimeSelectionScreenButtonPanelHeight)
    var landscapeStartTimerButtonFontSize by mutableIntStateOf((landscapeStartTimerButtonHeight * 0.5).toInt())

    // Landscape Preset Time Panel Dimensions
    var landscapePresetTimeFontSize by mutableIntStateOf((leftLandscapeTimeSelectionScreenPanelWidth * 0.10).toInt())
    var landscapePresetTimeNameFontSize by mutableIntStateOf((landscapePresetTimeFontSize * 0.60).toInt())
}