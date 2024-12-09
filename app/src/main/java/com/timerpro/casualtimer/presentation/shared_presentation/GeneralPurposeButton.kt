package com.timerpro.casualtimer.presentation.shared_presentation

import android.content.res.Configuration
import android.media.MediaPlayer
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewModelScope
import com.timerpro.casualtimer.data.shared_data.dimensions.GeneralPurposeButtonDimensions
import com.timerpro.casualtimer.data.stopwatch_data.stopwatch_states.stopwatchStates
import com.timerpro.casualtimer.functionality.shared_presentation_management.GeneralPurposeButtonManagement
import com.timerpro.casualtimer.functionality.stopwatch_functionality.stopwatchLapTimeFunctionality
import kotlinx.coroutines.launch

@Composable
fun GeneralPurposeButton(
    configuration: Configuration,
    modifier: Modifier = Modifier,
    dimensions: GeneralPurposeButtonDimensions = GeneralPurposeButtonDimensions(configuration),
    functionality: GeneralPurposeButtonManagement = GeneralPurposeButtonManagement(),
    title: String,
    lapDisplayListState: LazyListState = LazyListState(),
    alarmPlayer : MediaPlayer = MediaPlayer()
) {

    val context = LocalContext.current

    if (title == "Start Timer") { functionality.manageStartTimerButtonEnabledState() }

    // General Purpose Button Layout
    Box(
        modifier
            .padding(dimensions.externalPadding(title = title))
            .pointerInput(Unit){
                detectTapGestures (

                    // General Purpose Button On Click Logic
                    onPress = {
                        functionality.determineButtonOnPressState(
                            context = context, buttonTitle = title, alarmPlayer = alarmPlayer)

                        // Conditional That Animates Scrolls To Top Of Lap Display List
                         if (title == "Lap And Reset Stopwatch" && stopwatchStates.laps.size > 0)
                             stopwatchLapTimeFunctionality.viewModelScope.launch {
                             lapDisplayListState.scrollToItem(0)}
                        },
                    onTap = {functionality.determineButtonOnTapState(
                        context = context, buttonTitle = title, alarmPlayer = alarmPlayer)},
                    onDoubleTap = {}
                )
            }
            .shadow(
                elevation = dimensions.elevation,
                shape = RoundedCornerShape(dimensions.cornerRadius)
            )
            .background(
                color = if (title == "Start Timer") {
                    animateColorAsState(targetValue = functionality.determineButtonBackgroundColor(buttonTitle = title),
                        animationSpec = keyframes { durationMillis = 150 } ).value
                } else {
                    functionality.determineButtonBackgroundColor(buttonTitle = title)
                },
                shape = RoundedCornerShape(dimensions.cornerRadius)
            )
            .width(dimensions.buttonWidth(title = title))
            .height(dimensions.buttonHeight(title = title)),
        contentAlignment = Alignment.Center
    ) {

        // General Purpose Button Text
        Text(
            text = functionality.determineButtonText(buttonTitle = title),
            color = if (title == "Start Timer") {
                animateColorAsState(targetValue = functionality.determineButtonTextColor(buttonTitle = title),
                    animationSpec = keyframes { durationMillis = 150 } ).value
            } else {
                functionality.determineButtonTextColor(buttonTitle = title)
            },
            fontSize = dimensions.fontSize(title = title),
            fontWeight = FontWeight.SemiBold,
            letterSpacing = dimensions.letterSpacing
        )
    }
}