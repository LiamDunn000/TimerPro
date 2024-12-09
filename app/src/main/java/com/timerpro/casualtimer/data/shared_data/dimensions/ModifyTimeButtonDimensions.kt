package com.timerpro.casualtimer.data.shared_data.dimensions

import android.content.res.Configuration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions

class ModifyTimeButtonDimensions(
    configuration: Configuration,
    val dimensions: ScreenDimensions = ScreenDimensions(configuration)) {

    private fun determineSize(title: String, standardSize: Dp, smallSize: Dp): Dp {
        return if (title.contains("Preset")) dimensions.screenSize * smallSize
        else dimensions.screenSize * standardSize
    }

    fun buttonSize(title: String): Dp {
        return determineSize(title = title, standardSize = 0.03.dp, smallSize = 0.025.dp)
    }

    fun iconSize(title: String): Dp {
        return determineSize(title = title, standardSize = 0.02.dp, smallSize = 0.015.dp)
    }

    fun borderRadius(title: String): Dp {
        return determineSize(title = title, standardSize = 0.00168.dp, smallSize = 0.00163.dp)
    }
}