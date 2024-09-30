package com.timerpro.casualtimer.presentation.casual_timer_screen_presentation.casual_timer_screen_composables

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp

@Composable
fun ScreenSlider(
    onClick: () -> Unit,
    width: Int,
    height: Int,
    fontSize: Int,
    indicatorHeight: Int,
    dividerWidth: Int,
    dividerHeight: Int) {

    // Screen Slider Layout
    Column (
        modifier = Modifier
            .pointerInput(Unit) {
                detectTapGestures(

                    // Transition Between Screens
                    onPress = { onClick() })}

            .width(width = width.dp)
            .height(height = height.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly) {

        // Screen Slider Top Bar
        ScreenSliderTopBar(
            fontSize = fontSize,
            dividerWidth = dividerWidth,
            dividerHeight = dividerHeight)

        // Screen Slider Indicator
        ScreenSliderIndicator(
            width = width,
            height = indicatorHeight ) }}