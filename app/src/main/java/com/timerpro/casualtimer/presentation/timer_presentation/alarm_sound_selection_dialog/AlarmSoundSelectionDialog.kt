package com.timerpro.casualtimer.presentation.timer_presentation.alarm_sound_selection_dialog

import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.timerpro.casualtimer.data.shared_data.Colors
import com.timerpro.casualtimer.data.timer_data.timer_dimensions.alarm_sound_selection_dialog_dimensions.AlarmSoundSelectionDialogDimensions
import com.timerpro.casualtimer.data.timer_data.timer_states.alarmPlayer
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.timer_functionality.alarmStateFunctionality
import com.timerpro.casualtimer.presentation.shared_presentation.CustomRadioButton
import com.timerpro.casualtimer.presentation.shared_presentation.TextOnlyButton

@Composable
fun AlarmSoundSelection(
    context: Context = LocalContext.current,
    configuration: Configuration = LocalConfiguration.current,
    dimen: AlarmSoundSelectionDialogDimensions = AlarmSoundSelectionDialogDimensions(configuration),
) {

    if (timerStates.isAlarmSoundSelectionDialogOpen) {

        Dialog(onDismissRequest = {
            timerStates.isAlarmSoundSelectionDialogOpen = false
            timerStates.areChangesMadeToAlarmSound = false
        }) {
        Column(
            modifier = Modifier
                .background(
                    color = Colors().white,
                    shape = RoundedCornerShape(dimen.cornerRadius)
                    )
                .fillMaxWidth()
                .heightIn(max =  dimen.height)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimen.itemHeight),
                contentAlignment = Alignment.Center
            ) {

               Text(
                   text = "Select Alarm Sound",
                   color = Colors().darkGray,
                   fontSize = dimen.headerFontSize,
                   fontWeight = FontWeight.SemiBold
                   )
            }

            // Divider
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimen.dividerHeight)
                    .background(color = Colors().darkGray)
            )

            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {

                // Alarm Sound List
                items(timerStates.alarmSounds) { sound ->

                    // Alarm Sound List Item
                    Row(modifier = Modifier
                        .clickable {
                            timerStates.selectedAlarmSound = sound
                            timerStates.areChangesMadeToAlarmSound = true
                            alarmStateFunctionality.playAlarmSample(context = context, mediaPlayer = alarmPlayer.samplePlayer, path = sound.path)
                        }
                        .fillMaxWidth()
                        .height(dimen.itemHeight)
                        .padding(horizontal = dimen.itemHorizontalPadding),
                        horizontalArrangement = Arrangement.spacedBy(dimen.itemSpacing),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        CustomRadioButton(title = "Alarm Button", sound = sound)

                        Text(
                            text = sound.name,
                            color = if (sound == timerStates.selectedAlarmSound) Colors().lightBlue else Colors().gray,
                            fontSize = dimen.alarmSoundNameFontSize,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                            )
                    }

                    // Divider
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(dimen.dividerHeight)
                            .background(color = Colors().darkGray)
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimen.itemHeight),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Save Alarm Sound Button
                TextOnlyButton(title = "Save Alarm Sound")

                Box(
                    modifier = Modifier
                        .background(color = Colors().darkGray)
                        .width(dimen.buttonPanelDividerWidth)
                        .height(dimen.buttonPanelDividerHeight)
                )

                // Close Alarm Sound Selection Dialog
                TextOnlyButton(title = "Close Alarm Sound Selection Dialog")

            }

        }
        }
    }
}