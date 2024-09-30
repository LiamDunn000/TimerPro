package com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun LapDisplayListText(
    text: String,
    fontSize: Int) {

        // Lap Display List Header Text
        Text(
            text = text,
            fontSize = fontSize.sp,
            fontWeight = FontWeight.SemiBold) }
