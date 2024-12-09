package com.timerpro.casualtimer.data.timer_data.timer_dimensions.time_selection_screen_dimensions

import android.content.res.Configuration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates

class TimeSelectionScreenDimensions(
    configuration: Configuration,
    val dimensions: ScreenDimensions = ScreenDimensions(configuration)) {

    // Portrait Time Selection Screen Dimensions
    val portraitVerticalPadding = dimensions.screenSize * 0.06.dp
    val portraitHorizontalPadding = dimensions.screenSize * 0.015.dp
    val portraitTopSpacerWeight = 1f

    // Landscape Time Selection Screen Dimensions
    val landscapePanelWidth = dimensions.screenWidth / 2
    val landscapeVerticalPadding = dimensions.screenSize * 0.04.dp

    // Open Dialog Button Dimensions
    val openDialogButton = dimensions.screenSize * 0.013.sp
    val openDialogButtonPadding = dimensions.screenSize * 0.012.dp

    // Spacing
    val timeSelectorSpacing = dimensions.screenSize * 0.01.dp

    // Preset Time Panel Dimensions
    val portraitPresetTimeListWeight = if (timerStates.presetTimeList.isNotEmpty()) 2f else 1.7f
    fun size(orientation: String, standardSize: Double, largeSize: Double): Double {
        return if (orientation == "Portrait") dimensions.screenSize * standardSize
        else dimensions.screenSize * largeSize
    }

    fun presetTimePanelWidth(orientation: String): Dp {
        return size(orientation = orientation, standardSize = 0.11, largeSize = 0.22).dp
    }
    val presetTimePanelPadding = dimensions.screenSize * 0.01.dp
    val presetTimePanelElevation = dimensions.screenSize * 0.005.dp
    val presetTimePanelCornerRadius = 10
    fun presetTimePanelTitleFontSize(orientation: String): TextUnit {
        return size(orientation = orientation, standardSize = 0.013, largeSize = 0.0135).sp
    }
    fun presetTimePanelTimeFontSize(orientation: String): TextUnit {
        return size(orientation = orientation, standardSize = 0.02, largeSize = 0.025).sp
    }

    // Preset Time Options Panel Dimensions
    val presetTimeOptionsPanelIconSize = dimensions.screenSize * 0.021.dp
    val presetTimeOptionsPanelFontSize = dimensions.screenSize * 0.0127.sp
    val presetTimeOptionsPanelLetterSpacing = dimensions.screenSize * 0.0008.sp
    val presetTimeOptionsPanelBottomPadding = dimensions.screenSize * 0.01.dp
}