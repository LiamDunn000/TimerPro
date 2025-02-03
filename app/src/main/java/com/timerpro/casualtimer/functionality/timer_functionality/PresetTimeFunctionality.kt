package com.timerpro.casualtimer.functionality.timer_functionality

import android.content.Context
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.timerpro.casualtimer.data.timer_data.timer_states.TimerStates
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.general_functionality.generalFunctionality
import com.timerpro.timertest.data.PresetTime
import com.timerpro.timertest.data.presetTimeDatabase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

val presetTimeFunctionality = PresetTimeFunctionality()

class PresetTimeFunctionality(val t: TimerStates = timerStates): ViewModel() {

    /* DAO FUNCTIONS
    ----------------------------------------------------------------------------------------------*/
    fun insertPresetTime(context: Context, presetTime: PresetTime){
        viewModelScope.launch {
            try {
                presetTimeDatabase.presetTimeDao.insertPresetTime(presetTime = presetTime)
                generalFunctionality.showToast(context = context, message = "Preset Time Added")
        } catch (e: Exception) {
            generalFunctionality.showToast(context = context, message = "Error Preset Time Not Added")
            return@launch
                }
            }
        }

    fun updatePresetTime(context: Context){

        generalFunctionality.vibrateOnButtonClick(context = context)

        if (t.areChangesMadeToPresetTime) {
            viewModelScope.launch {
                try {
                    presetTimeDatabase.presetTimeDao.updatePresetTime(
                        presetTime =
                        t.selectedPresetTimeList[0].copy(
                            name = t.presetTimeTitleTextFieldValue,
                            hours = t.presetHourInput.text.toInt(),
                            minutes = t.presetMinuteInput.text.toInt(),
                            seconds = t.presetSecondInput.text.toInt()
                        )
                    )
                        delay(3)
                        resetPresetTimeOptionPanelState()
                        resetPresetTimeDialogState()
                        generalFunctionality.showToast(
                            context = context,
                            message = "Preset Time Updated"
                        )
                    } catch (e: Exception) {
                        resetPresetTimeOptionPanelState()
                    resetPresetTimeDialogState()
                    generalFunctionality.showToast(context = context, message = "Error Updating Preset Time")
                    return@launch
                }
            }
        } else resetPresetTimeOptionPanelState(); resetPresetTimeDialogState()
    }

    fun deletePresetTime(context: Context, list: List<PresetTime>){
        viewModelScope.launch {
            try {
                generalFunctionality.showToast(
                    context = context,
                    message = "${t.selectedPresetTimeList.size} Preset Time Deleted")
                delay(1)
                presetTimeDatabase.presetTimeDao.deletePresetTime(list = list)
            } catch (e: Exception) {
                generalFunctionality.showToast(context = context, message = "Error Deleting Preset Time")
                return@launch
            }
            }
        }

    fun retrieveAllPresetTimes() = presetTimeDatabase.presetTimeDao.retrieveAllPresetTimes().asLiveData(viewModelScope.coroutineContext)
    // ---------------------------------------------------------------------------------------------

    // PRESET TIME DIALOG --------------------------------------------------------------------------

    fun openCreatePresetTimeDialog() {
        t.isPresetTimeBeingEdited = false
        t.isAddPresetTimeDialogOpen = true
        t.selectedPresetTimeList = listOf()
        presetTimeFunctionality.resetAddPresetTimeDialogTextFieldValues()
    }

    fun resetPresetTimeDialogState() {
        t.isAddPresetTimeDialogOpen = false
        t.isPresetTimeBeingEdited = false
        resetAddPresetTimeDialogTextFieldValues() }

    fun resetAddPresetTimeDialogTextFieldValues() {
            t.presetTimeTitleTextFieldValue = ""
            t.presetHourInput = TextFieldValue("0")
            t.presetMinuteInput = TextFieldValue("0")
            t.presetSecondInput = TextFieldValue("0")
    }

    fun loadPresetTimeToDialog(presetTime: PresetTime) {
        t.presetTimeTitleTextFieldValue = presetTime.name
        t.presetHourInput = TextFieldValue(presetTime.hours.toString())
        t.presetMinuteInput = TextFieldValue(presetTime.minutes.toString())
        t.presetSecondInput = TextFieldValue(presetTime.seconds.toString())
    }
    // ---------------------------------------------------------------------------------------------

    fun resetPresetTimeOptionPanelState() {
        t.areChangesMadeToPresetTime = false
        t.selectedPresetTimeList = listOf()
    }

    fun addOrRemovePresetTimeFromList(presetTime: PresetTime, isSelected: Boolean) {
        if (isSelected)
        {t.selectedPresetTimeList += presetTime}
        else
        {t.selectedPresetTimeList -= presetTime}
    }

    fun covertTimeToPresetTime(seconds: Int, minutes: Int, hours: Int) {
        t.secondInput = TextFieldValue(seconds.toString())
        t.minuteInput = TextFieldValue(minutes.toString())
        t.hourInput = TextFieldValue(hours.toString())
    }
}
