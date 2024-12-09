package com.timerpro.casualtimer.data.shared_data

import android.content.res.Configuration

class ScreenDimensions(configuration: Configuration) {

    // Screen Width
    val screenWidth = configuration.screenWidthDp

    // Screen Height
    val screenHeight = configuration.screenHeightDp

    // Screen Size
    val screenSize = screenWidth + screenHeight

}