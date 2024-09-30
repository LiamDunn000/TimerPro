package com.timerpro.casualtimer.presentation.timer_presentation.count_down_timer_screen.count_down_timer_screen_composables

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.timerpro.casualtimer.data.timer_data.timer_colors.timerColors

@Composable
fun TimesUpMessage(
    context: Context,
    fontSize: Int,
    /*buttonWidth:*/) {

    // Times Up Message Context
    //val timesUpMessageContext = LocalContext.current

    // Ringtone Uri
    //val ringtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)

    // Ringtone
    //val ringtone = RingtoneManager.getRingtone(timesUpMessageContext, ringtoneUri)



    // Play Audio When Time Is Up
    //LaunchedEffect(Unit) { timerAudioStateFunctionality.playRingtone(ringtone = ringtone) }

    // Times Up Message Layout
    Column(
        modifier = Modifier
            .background(color = timerColors.timesUpScreenBackgroundColor)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Times Up Text
        Text(
            text = "Times Up!",
            color = timerColors.timesUpScreenFontColor,
            fontSize = fontSize.sp)

        Row() {

            // Cancel Timer Button
            CancelTimerButton(
                context = context,
                width = 150,
                height = 50,
                fontSize = fontSize)
        }
    }
}