package com.timerpro.casualtimer.data.shared_data.dimensions

import android.content.res.Configuration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions

class GeneralPurposeButtonDimensions(
    configuration: Configuration,
    val dimensions: ScreenDimensions = ScreenDimensions(configuration)) {

    fun size(title: String, standardSize: Double, smallSize: Double): Double {
         return title.let { if (it == "Save Preset Time"|| it == "Close Preset Time Dialog" ||
             it == "Update Preset Time" || it == "Delete Preset Time" || it == "Close Alarm Sound Selection Dialog"
                ) dimensions.screenSize * smallSize else  dimensions.screenSize * standardSize
            }
    }

    // General Purpose Button Dimensions
    fun buttonWidth(title: String): Dp {
        return size(title = title, standardSize = 0.115, smallSize = 0.1).dp
    }
    fun buttonHeight(title: String): Dp {
        return size(title = title, standardSize = 0.04, smallSize = 0.035).dp
        }
    fun externalPadding(title: String): Dp {
        return size(title = title, standardSize = 0.015, smallSize = 0.0).dp
    }

    val elevation = dimensions.screenSize * 0.005.dp

    val cornerRadius = 13

    // General Purpose Button Text Dimensions
    fun fontSize(title: String): TextUnit {
        return size(title = title, standardSize = 0.017, smallSize = 0.014).sp
    }
    val letterSpacing = dimensions.screenSize * 0.0004.sp
}