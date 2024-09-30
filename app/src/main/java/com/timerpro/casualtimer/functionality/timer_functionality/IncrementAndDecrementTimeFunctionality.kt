package com.timerpro.casualtimer.functionality.timer_functionality

import android.content.Context
import androidx.compose.ui.text.input.TextFieldValue
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.casual_timer_screen_functionality.casualTimerScreenFunctionality

// Global Instance Of Increment And Decrement Time Functionality
val incrementAndDecrementTimeFunctionality = IncrementAndDecrementTimeFunctionality()

class IncrementAndDecrementTimeFunctionality {

    /* INCREMENT AND DECREMENT TIME
    ----------------------------------------------------------------------------------------------*/
    // Increment Seconds
    fun incrementSeconds(context: Context) {

        // Conditional That Increments Seconds
        when { timerStates.secondInput.text.isNotEmpty() && timerStates.secondInput.text.toInt() < 59 -> {
            timerStates.secondInput = TextFieldValue((timerStates.secondInput.text.toInt() + 1).toString())
            casualTimerScreenFunctionality.vibrateOnButtonClick(context = context) }}}

    // Decrement Seconds
    fun decrementSeconds(context: Context) {

        // Conditional That Decrements Minutes
        when { timerStates.secondInput.text.isNotEmpty() && timerStates.secondInput.text.toInt() > 0 -> {
            casualTimerScreenFunctionality.vibrateOnButtonClick(context = context)
            timerStates.secondInput = TextFieldValue((timerStates.secondInput.text.toInt() - 1).toString()) }}}

    // Increment Minutes
    fun incrementMinutes(context: Context) {

        // Conditional That Increments Minutes
        when { timerStates.minuteInput.text.isNotEmpty() && timerStates.minuteInput.text.toInt() < 59 -> {
            timerStates.minuteInput = TextFieldValue((timerStates.minuteInput.text.toInt() + 1).toString())
            casualTimerScreenFunctionality.vibrateOnButtonClick(context = context) }}}

    // Decrement Minutes
    fun decrementMinutes(context: Context) {

        // Conditional That Decrements Minutes
        when { timerStates.minuteInput.text.isNotEmpty() && timerStates.minuteInput.text.toInt() > 0 -> {
            casualTimerScreenFunctionality.vibrateOnButtonClick(context = context)
            timerStates.minuteInput = TextFieldValue((timerStates.minuteInput.text.toInt() - 1).toString()) }}}

    // Increment Hours
    fun incrementHours(context: Context) {

        // Conditional That Increments Hours
        when { timerStates.hourInput.text.isNotEmpty() && timerStates.hourInput.text.toInt() < 99 -> {
            timerStates.hourInput = TextFieldValue((timerStates.hourInput.text.toInt() + 1).toString())
            casualTimerScreenFunctionality.vibrateOnButtonClick(context = context)
            }}}

    // Decrement Hours
    fun decrementHours(context: Context) {

        // Conditional That Decrements Hours
        when { timerStates.hourInput.text.isNotEmpty() && timerStates.hourInput.text.toInt() > 0 ->{
            casualTimerScreenFunctionality.vibrateOnButtonClick(context = context)
            timerStates.hourInput = TextFieldValue((timerStates.hourInput.text.toInt() - 1).toString())
                }}}
    //----------------------------------------------------------------------------------------------

    /* INCREMENT AND DECREMENT PRESET TIME
    ----------------------------------------------------------------------------------------------*/
    // Increment Preset Seconds
    fun incrementPresetSeconds(context: Context) {

        // Conditional That Increments Preset Seconds
        when { timerStates.presetSecondInput.text.isNotEmpty() && timerStates.presetSecondInput.text.toInt() < 59 -> {
            timerStates.presetSecondInput = TextFieldValue((timerStates.presetSecondInput.text.toInt() + 1).toString())
            casualTimerScreenFunctionality.vibrateOnButtonClick(context = context)}}}

    // Decrement Preset Seconds
    fun decrementPresetSeconds(context: Context) {

        // Conditional That Decrements Preset Seconds
        when { timerStates.presetSecondInput.text.isNotEmpty() && timerStates.presetSecondInput.text.toInt() > 0 -> {
            casualTimerScreenFunctionality.vibrateOnButtonClick(context = context)
            timerStates.presetSecondInput = TextFieldValue((timerStates.presetSecondInput.text.toInt() - 1).toString()) }}}

    // Increment Preset Minutes
    fun incrementPresetMinutes(context: Context) {

        // Conditional That Increments Minutes
        when { timerStates.presetMinuteInput.text.isNotEmpty() && timerStates.minuteInput.text.toInt() < 59 -> {
            timerStates.presetMinuteInput = TextFieldValue((timerStates.presetMinuteInput.text.toInt() + 1).toString())
            casualTimerScreenFunctionality.vibrateOnButtonClick(context = context) }}}

    // Decrement Preset Minutes
    fun decrementPresetMinutes(context: Context) {

        // Conditional That Decrements Minutes
        when { timerStates.presetMinuteInput.text.isNotEmpty() && timerStates.presetMinuteInput.text.toInt() > 0 -> {
            casualTimerScreenFunctionality.vibrateOnButtonClick(context = context)
            timerStates.presetMinuteInput = TextFieldValue((timerStates.presetMinuteInput.text.toInt() - 1).toString()) }}}

    // Increment Preset Hours
    fun incrementPresetHours(context: Context) {

        // Conditional That Increments Hours
        when { timerStates.presetHourInput.text.isNotEmpty() && timerStates.hourInput.text.toInt() < 99 -> {
            timerStates.presetHourInput = TextFieldValue((timerStates.presetHourInput.text.toInt() + 1).toString())
            casualTimerScreenFunctionality.vibrateOnButtonClick(context = context)}}}

    // Decrement Preset Hours
    fun decrementPresetHours(context: Context) {

        // Conditional That Decrements Hours
        when { timerStates.presetHourInput.text.isNotEmpty() && timerStates.presetHourInput.text.toInt() > 0 ->{
            casualTimerScreenFunctionality.vibrateOnButtonClick(context = context)
            timerStates.presetHourInput = TextFieldValue((timerStates.presetHourInput.text.toInt() - 1).toString()) }}}
}