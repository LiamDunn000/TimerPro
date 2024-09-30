package com.timerpro.casualtimer.presentation.casual_timer_screen_presentation.casual_timer_screen_layouts

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.media.MediaPlayer
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_datastore.CasualTimerDatastore
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_screen_dimensions.PortraitCasualTimerDimensions
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_screen_states.casualTimerScreenStates
import com.timerpro.casualtimer.functionality.casual_timer_screen_functionality.casualTimerScreenFunctionality
import com.timerpro.casualtimer.presentation.casual_timer_screen_presentation.casual_timer_screen_composables.ScreenSlider
import com.timerpro.casualtimer.presentation.stopwatch_presentation.stopwatch_layouts.PortraitStopwatchScreen
import com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.time_selection_screen_layouts.PortraitTimeSelectionScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PortraitCasualTimerScreen(
    context: Context,
    configuration: Configuration,
    navController: NavHostController,
    lapDisplayListState: LazyListState,
    alarmPlayer: MediaPlayer,
    casualTimerDatastore: CasualTimerDatastore) {

    // Portrait Casual Timer Home Screen Layout
    Scaffold(
        modifier = Modifier.padding(WindowInsets.systemBars.asPaddingValues()),
        bottomBar = {

            ScreenSlider(
            onClick = { casualTimerScreenFunctionality.transitionBetweenScreens(navController, context) },
            width = (PortraitCasualTimerDimensions(configuration).portraitScreenSliderWidth),
            height = (PortraitCasualTimerDimensions(configuration).portraitScreenSliderHeight),
            fontSize = (PortraitCasualTimerDimensions(configuration).portraitScreenSliderFontSize),
            indicatorHeight = (PortraitCasualTimerDimensions(configuration).portraitScreenSliderIndicatorHeight),
            dividerWidth = (PortraitCasualTimerDimensions(configuration).portraitScreenSliderTopBarDividerWidth),
            dividerHeight = (PortraitCasualTimerDimensions(configuration).portraitScreenSliderTopBarDividerHeight),
            )
                }) {

        // Portrait Screen Transition Logic
        NavHost(navController = navController, casualTimerScreenStates.startDestination) {

            // Transition To Portrait Stopwatch Screen
            composable("Stopwatch Screen",
                deepLinks = listOf(navDeepLink {
                    uriPattern = casualTimerScreenStates.fullStopwatchScreenDeepLinkUri
                    action = Intent.ACTION_VIEW
                }),
                enterTransition = {slideInHorizontally(initialOffsetX = { -it })},
                exitTransition = {slideOutHorizontally(targetOffsetX = { -it })}) {
                PortraitStopwatchScreen(
                    context = context,
                    configuration = configuration,
                    lapDisplayListState = lapDisplayListState) }

            // Transition To Portrait Time Selection Screen
            composable("Time Selection Screen",
                deepLinks = listOf(navDeepLink {
                    uriPattern = casualTimerScreenStates.fullTimeSelectionScreenDeepLinkUri
                    action = Intent.ACTION_VIEW
                }),
                enterTransition = {slideInHorizontally(initialOffsetX = { it })},
                exitTransition = {slideOutHorizontally(targetOffsetX = { it })}) {
                PortraitTimeSelectionScreen(
                    context = context,
                    configuration = configuration,
                    alarmPlayer = alarmPlayer,
                    casualTimerDatastore = casualTimerDatastore)}}}}