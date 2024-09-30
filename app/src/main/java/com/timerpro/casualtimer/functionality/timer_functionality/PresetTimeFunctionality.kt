package com.timerpro.casualtimer.functionality.timer_functionality

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.timertest.data.PresetTime
import com.timerpro.timertest.data.presetTimeDatabase
import kotlinx.coroutines.launch

val presetTimeFunctionality = PresetTimeFunctionality()

class PresetTimeFunctionality(): ViewModel() {

    /* DAO FUNCTIONS
    ----------------------------------------------------------------------------------------------*/
    // Insert Preset Time
    fun insertPresetTime(presetTime: PresetTime){
        viewModelScope.launch {
            presetTimeDatabase.presetTimeDao.insertPresetTime(presetTime = presetTime) }}

    // Update Preset Time
    fun updatePresetTime(presetTime: PresetTime){
        viewModelScope.launch {
            presetTimeDatabase.presetTimeDao.updatePresetTime(presetTime = presetTime) }}

    // Delete Preset Time
    fun deletePresetTime(presetTime: PresetTime){
        viewModelScope.launch {
            presetTimeDatabase.presetTimeDao.deletePresetTime(presetTime = presetTime) }}

    // Retrieve All Preset Times
    fun retrieveAllPresetTimes() = presetTimeDatabase.presetTimeDao.retrieveAllPresetTimes().asLiveData(viewModelScope.coroutineContext)
    // ---------------------------------------------------------------------------------------------


    // Reset Add Preset Time Dialog State
    fun resetAddPresetTimeDialogState() {

        // Close Add Preset Time Dialog
        timerStates.isAddPresetTimeDialogOpen = false

        // Reset Add Preset Time Dialog Text Field Values
        resetAddPresetTimeDialogTextFieldValues() }

    fun resetAddPresetTimeDialogTextFieldValues() {

        // Reset Add Preset Time Dialog Text Field Values
        timerStates.presetTimeNameTextFieldValue = ""
        timerStates.presetHourInput = TextFieldValue("0")
        timerStates.presetMinuteInput = TextFieldValue("0")
        timerStates.presetSecondInput = TextFieldValue("0") }

    // Convert Time To Preset Time
    fun covertTimeToPresetTime(
        seconds: Int,
        minutes: Int,
        hours: Int) {

        // Pass Preset Time Values To Timer Text Field Values
        timerStates.secondInput = TextFieldValue(seconds.toString())
        timerStates.minuteInput = TextFieldValue(minutes.toString())
        timerStates.hourInput = TextFieldValue(hours.toString()) }

}
