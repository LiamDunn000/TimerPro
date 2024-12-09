package com.timerpro.casualtimer.presentation.shared_presentation

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import com.timerpro.casualtimer.data.shared_data.Colors
import com.timerpro.casualtimer.data.shared_data.dimensions.ModifyTimeButtonDimensions
import com.timerpro.casualtimer.functionality.shared_presentation_management.ModifyTimeButtonManagement

@Composable
fun ModifyTimeButton(
    configuration: Configuration,
    dimensions: ModifyTimeButtonDimensions = ModifyTimeButtonDimensions(configuration),
    functionality: ModifyTimeButtonManagement = ModifyTimeButtonManagement(),
    title: String,
    action: String) {

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .pointerInput(Unit) {
                detectTapGestures (
                    onPress = {
                        functionality.determineButtonFunctionality(
                            context = context,
                            title = title,
                            action = action)
                    }
                )
                 }
            .border(
                color = Colors().black,
                width = dimensions.borderRadius(title = title),
                shape = CircleShape
            )
            .size(dimensions.buttonSize(title = title)),
        contentAlignment = Alignment.Center
    ) {

        // Increment Time Button Icon
        Icon(
            modifier = Modifier.size(dimensions.iconSize(title = title)),
            imageVector = functionality.determineIcon(buttonAction = action),
            contentDescription = null,
            tint = Colors().black
        )
    }
}