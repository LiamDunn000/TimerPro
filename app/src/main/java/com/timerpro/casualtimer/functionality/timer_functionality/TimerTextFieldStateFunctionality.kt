package com.timerpro.casualtimer.functionality.timer_functionality

import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates

val timerTextFieldStateFunctionality = TimerTextFieldStateFunctionality()

class TimerTextFieldStateFunctionality: ViewModel() {

    /* MANAGE TIME TEXT FIELD STATES
    ----------------------------------------------------------------------------------------------*/
    // Manage Second TextField States
    fun manageSecondTextFieldStates() {

        // Conditional That Selects The Entire Value Of Second Text Field
        if (timerStates.isSecondTextFieldFocused && timerStates.secondInput.text.length > 1) {
            timerStates.secondInput = timerStates.secondInput.copy(selection = TextRange(0, timerStates.secondInput.text.length))}

        // Conditional That Adds A Zero To Beginning Of Second Text Field
        if (!timerStates.isSecondTextFieldFocused && timerStates.secondInput.text.length == 1) {
            timerStates.secondInput = TextFieldValue("0${timerStates.secondInput.text}")

            //  Conditional That Converts Empty Second Text Field To 00
        } else if (!timerStates.isSecondTextFieldFocused && timerStates.secondInput.text.isEmpty()) {
            timerStates.secondInput = TextFieldValue("00") }}

    // Manage Minute TextField States
    fun manageMinuteTextFieldStates() {

        // Conditional That Selects The Entire Value Of Minute Text Field
        if (timerStates.isMinutesTextFieldFocused && timerStates.minuteInput.text.length > 1) {
            timerStates.minuteInput = timerStates.minuteInput.copy(selection = TextRange(0, timerStates.minuteInput.text.length)) }

        // Conditional That Adds A Zero To Beginning Of Minute Text Field
        if (!timerStates.isMinutesTextFieldFocused && timerStates.minuteInput.text.length == 1) {
            timerStates.minuteInput = TextFieldValue("0${timerStates.minuteInput.text}")

            // Conditional That Converts Empty Minute Text Field To 00
        } else if (!timerStates.isMinutesTextFieldFocused && timerStates.minuteInput.text.isEmpty()) {
            timerStates.minuteInput = TextFieldValue("00") }}

    // Manage Hours TextField States
    fun manageHoursTextFieldStates() {

        // Conditional That Selects The Entire Value Of Hours Text Field
        if (timerStates.isHoursTextFieldFocused && timerStates.hourInput.text.length > 1) {
            timerStates.hourInput = timerStates.hourInput.copy(selection = TextRange(0, timerStates.hourInput.text.length))}

        // Conditional That Adds A Zero To Beginning Of Hours Text Field
        if (!timerStates.isHoursTextFieldFocused && timerStates.hourInput.text.length == 1) {
            timerStates.hourInput = TextFieldValue("0${timerStates.hourInput.text}")

            // Conditional That Converts Empty Hours Text Field To 00
        } else if (!timerStates.isHoursTextFieldFocused && timerStates.hourInput.text.isEmpty()) {
            timerStates.hourInput = TextFieldValue("00") }}
    //----------------------------------------------------------------------------------------------

    /* MANAGE PRESET TIME TEXT FIELD STATES
    ----------------------------------------------------------------------------------------------*/
    // Manage Preset Second TextField States
    fun managePresetSecondTextFieldStates() {

        // Conditional That Selects The Entire Value Of Preset Second Text Field
        if (timerStates.isPresetSecondTextFieldFocused && timerStates.presetSecondInput.text.length > 1) {
            timerStates.presetSecondInput = timerStates.presetSecondInput.copy(selection = TextRange(0, timerStates.presetSecondInput.text.length))}

        // Conditional That Adds A Zero To Beginning Of Preset Second Text Field
        if (!timerStates.isPresetSecondTextFieldFocused && timerStates.presetSecondInput.text.length == 1) {
            timerStates.presetSecondInput = TextFieldValue("0${timerStates.presetSecondInput.text}")

            //  Conditional That Converts Empty Preset Second Text Field To 00
        } else if (!timerStates.isPresetSecondTextFieldFocused && timerStates.presetSecondInput.text.isEmpty()) {
            timerStates.presetSecondInput = TextFieldValue("00") }}


    // Manage Preset Minute TextField States
    fun managePresetMinuteTextFieldStates() {

        // Conditional That Selects The Entire Value Of Preset Minute Text Field
        if (timerStates.isPresetMinutesTextFieldFocused && timerStates.presetMinuteInput.text.length > 1) {
            timerStates.presetMinuteInput = timerStates.presetMinuteInput.copy(selection = TextRange(0, timerStates.presetMinuteInput.text.length)) }

        // Conditional That Adds A Zero To Beginning Of Preset Minute Text Field
        if (!timerStates.isPresetMinutesTextFieldFocused && timerStates.presetMinuteInput.text.length == 1) {
            timerStates.presetMinuteInput = TextFieldValue("0${timerStates.presetMinuteInput.text}")

            // Conditional That Converts Empty Preset Minute Text Field To 00
        } else if (!timerStates.isPresetMinutesTextFieldFocused && timerStates.presetMinuteInput.text.isEmpty()) {
            timerStates.presetMinuteInput = TextFieldValue("00") }}

    // Manage Preset Hours TextField States
    fun managePresetHoursTextFieldStates() {

        // Conditional That Selects The Entire Value Of Preset Hour Text Field
        if (timerStates.isPresetHourTextFieldFocused && timerStates.presetHourInput.text.length > 1) {
            timerStates.presetHourInput = timerStates.presetHourInput.copy(selection = TextRange(0, timerStates.presetHourInput.text.length))}

        // Conditional That Adds A Zero To Beginning Of Preset Hour Text Field
        if (!timerStates.isPresetHourTextFieldFocused && timerStates.presetHourInput.text.length == 1) {
            timerStates.presetHourInput = TextFieldValue("0${timerStates.presetHourInput.text}")

            // Conditional That Converts Empty Preset Hours Text Field To 00
        } else if (!timerStates.isPresetHourTextFieldFocused && timerStates.presetHourInput.text.isEmpty()) {
            timerStates.presetHourInput = TextFieldValue("00") }}
    //----------------------------------------------------------------------------------------------
}