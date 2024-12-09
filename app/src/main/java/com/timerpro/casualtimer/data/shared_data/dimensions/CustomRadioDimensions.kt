package com.timerpro.casualtimer.data.shared_data.dimensions

import android.content.res.Configuration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.timerpro.casualtimer.data.shared_data.ScreenDimensions

class CustomRadioDimensions(
    configuration: Configuration,
    dimensions: ScreenDimensions = ScreenDimensions(configuration)) {

    val buttonSize = dimensions.screenSize * 0.016.dp
    val borderWidth = dimensions.screenSize * 0.002.dp
    val externalPadding = dimensions.screenSize * 0.0015.dp
}