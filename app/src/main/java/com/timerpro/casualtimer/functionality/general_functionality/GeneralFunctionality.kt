package com.timerpro.casualtimer.functionality.general_functionality

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.widget.Toast
import androidx.navigation.NavController
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_screen_states.sharedStates
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.stopwatch_functionality.stopwatch_notification.StopwatchNotificationFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.presetTimeFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.timer_notification.TimerNotificationFunctionality

// Global Instance Of General Functionality
val generalFunctionality = GeneralFunctionality()

class GeneralFunctionality {

    // Vibrate On Button Click
    fun vibrateOnButtonClick(context: Context){

        // Conditional That Vibrates Device When Button Is Clicked Depending On Build Version
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
            vibratorManager.defaultVibrator.vibrate(VibrationEffect.createOneShot(15, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            vibrator.vibrate(25) }}

    fun showToast(context: Context, message: String) {
        val toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
        toast.show() }

    // Transition Between Screens
    fun transitionBetweenScreens(navController: NavController, context: Context) {

        // Vibrate On Button Click
        generalFunctionality.vibrateOnButtonClick(context = context)

        // Toggle Screen Slider
        sharedStates.isScreenSliderClicked = !sharedStates.isScreenSliderClicked

        // Conditional That Determines Screen Transition
        when (sharedStates.isScreenSliderClicked) {

            // Transition To Time Selection Screen
            true -> navController.navigate("Time Selection Screen")

            // Transition To Stopwatch Screen
            false -> {navController.navigate("Stopwatch Screen") }}}

    // Move Slider To Stopwatch If Deep Link Is Clicked
    fun moveSliderToStopwatchIfDeepLinkIsClicked(context: Context) {

        // Conditional That Transitions Slider To Stopwatch When Deep Link Is Clicked
        when {
            StopwatchNotificationFunctionality(context).stopwatchDeepLinkIntent.data != null &&
            StopwatchNotificationFunctionality(context).stopwatchDeepLinkIntent.data?.scheme == sharedStates.casualTimerDeepLinkUri &&
            StopwatchNotificationFunctionality(context).stopwatchDeepLinkIntent.data?.host == sharedStates.stopwatchScreenDeepLinkUri
            -> {sharedStates.isScreenSliderClicked = false; presetTimeFunctionality.resetPresetTimeOptionPanelState()}}}

    // Move Slider To Timer If Deep Link Is Clicked
    fun moveSliderToTimerIfDeepLinkIsClicked(context: Context) {

        // Conditional That Transitions Slider To Timer When Deep Link Is Clicked
        when {
            TimerNotificationFunctionality(context).timerDeepLinkIntent.data != null &&
            TimerNotificationFunctionality(context).timerDeepLinkIntent.data?.scheme == sharedStates.casualTimerDeepLinkUri &&
            TimerNotificationFunctionality(context).timerDeepLinkIntent.data?.host == sharedStates.timeSelectionScreenDeepLinkUri
            -> {sharedStates.isScreenSliderClicked = true}}}

    }

