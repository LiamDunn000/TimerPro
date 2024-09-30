package com.timerpro.casualtimer.functionality.casual_timer_screen_functionality

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import androidx.navigation.NavController
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_screen_states.casualTimerScreenStates
import com.timerpro.casualtimer.functionality.stopwatch_functionality.stopwatch_notification.StopwatchNotificationFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.timer_notification.TimerNotificationFunctionality

// Global Instance Of CasualTimerScreenFunctionality
val casualTimerScreenFunctionality = CasualTimerScreenFunctionality()

class CasualTimerScreenFunctionality {

    // Vibrate On Button Click
    fun vibrateOnButtonClick(context: Context){

        // Conditional That Vibrates Device When Button Is Clicked Depending On Build Version
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
            vibratorManager.defaultVibrator.vibrate(VibrationEffect.createOneShot(30, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            vibrator.vibrate(30) }}

    // Transition Between Screens
    fun transitionBetweenScreens(navController: NavController, context: Context) {

        // Vibrate On Button Click
        casualTimerScreenFunctionality.vibrateOnButtonClick(context = context)

        // Toggle Screen Slider
        casualTimerScreenStates.isScreenSliderClicked = !casualTimerScreenStates.isScreenSliderClicked

        // Conditional That Determines Screen Transition
        when (casualTimerScreenStates.isScreenSliderClicked) {

            // Transition To Time Selection Screen
            true -> navController.navigate("Time Selection Screen")

            // Transition To Stopwatch Screen
            false -> {navController.navigate("Stopwatch Screen") }}}

    // Determine Which Screen Is Shown
    /*fun determineWhichScreenIsShown(savedScreen: Boolean) {

        // Conditional That Determines Which Screen Is Shown
         when {

             // Transition To Stopwatch Screen
             !savedScreen -> {
                 casualTimerScreenStates.startDestination = "Stopwatch Screen";
                 casualTimerScreenStates.isScreenSliderClicked = false }

             // Transition To Time Selection Screen
             savedScreen -> {
                 casualTimerScreenStates.startDestination = "Time Selection Screen"
                 casualTimerScreenStates.isScreenSliderClicked = true }}}*/

    // Move Slider To Stopwatch If Deep Link Is Clicked
    fun moveSliderToStopwatchIfDeepLinkIsClicked(context: Context) {

        // Conditional That Transitions Slider To Stopwatch When Deep Link Is Clicked
        when {
            StopwatchNotificationFunctionality(context).stopwatchDeepLinkIntent.data != null &&
            StopwatchNotificationFunctionality(context).stopwatchDeepLinkIntent.data?.scheme == casualTimerScreenStates.casualTimerDeepLinkUri &&
            StopwatchNotificationFunctionality(context).stopwatchDeepLinkIntent.data?.host == casualTimerScreenStates.stopwatchScreenDeepLinkUri
            -> {casualTimerScreenStates.isScreenSliderClicked = false}}}

    // Move Slider To Timer If Deep Link Is Clicked
    fun moveSliderToTimerIfDeepLinkIsClicked(context: Context) {

        // Conditional That Transitions Slider To Timer When Deep Link Is Clicked
        when {
            TimerNotificationFunctionality(context).timerDeepLinkIntent.data != null &&
            TimerNotificationFunctionality(context).timerDeepLinkIntent.data?.scheme == casualTimerScreenStates.casualTimerDeepLinkUri &&
            TimerNotificationFunctionality(context).timerDeepLinkIntent.data?.host == casualTimerScreenStates.timeSelectionScreenDeepLinkUri
            -> {casualTimerScreenStates.isScreenSliderClicked = true}}}

    }

