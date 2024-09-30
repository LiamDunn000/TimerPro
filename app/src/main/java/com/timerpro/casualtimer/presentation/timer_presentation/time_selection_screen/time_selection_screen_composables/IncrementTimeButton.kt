package com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_composables

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.timerpro.casualtimer.data.timer_data.timer_colors.timerColors

@Composable
fun IncrementTimeButton(
    onClick: () -> Unit,
    size: Int,
    iconSize: Int) {

    // Increment Time Button Layout
    Card(
        modifier = Modifier
            .size(size.dp),
        colors = CardDefaults.cardColors(containerColor = timerColors.incrementAndDecrementButtonColor),
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(
            modifier = Modifier
                .clickable { onClick() }
                .border(
                    color = timerColors.incrementAndDecrementButtonBorderColor,
                    width = 2.dp,
                    shape = CircleShape
                )
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            // Increment Time Button Icon
            Icon(
                modifier = Modifier.size(iconSize.dp),
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = null,
                tint = timerColors.incrementAndDecrementButtonIconColor
            )
        }
    }

}