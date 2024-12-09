package com.timerpro.casualtimer.data.shared_data.dimensions

import android.content.res.Configuration
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions

class TimeSelectorDimensions(
    configuration: Configuration,
    val dimensions: ScreenDimensions = ScreenDimensions(configuration)) {

    private fun determineSize(title: String, standardSize: Double, smallSize: Double): Double {
        return if (title.contains("Preset")) dimensions.screenSize * smallSize
        else dimensions.screenSize * standardSize
    }

    fun selectorSize(title: String): Double {
        return determineSize(title = title, standardSize = 0.09, smallSize = 0.065)
    }

    fun fontSize(title: String): Double {
        return determineSize(title = title, standardSize = 0.044, smallSize = 0.03)
    }

    fun verticalSpacing(title: String): Double {
        return determineSize(title = title, standardSize = 0.008, smallSize = 0.002)
    }

}