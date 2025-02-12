package com.timerpro.casualtimer

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.timerpro.casualtimer.data.casual_timer_screen_data.casual_timer_screen_states.sharedStates
import com.timerpro.casualtimer.data.timer_data.storage.alarm_sound_storage.alarmSoundStorage
import com.timerpro.casualtimer.data.timer_data.timer_states.alarmPlayer
import com.timerpro.casualtimer.data.timer_data.timer_states.timerStates
import com.timerpro.casualtimer.functionality.general_functionality.generalFunctionality
import com.timerpro.casualtimer.functionality.general_functionality.permissionFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.alarmStateFunctionality
import com.timerpro.casualtimer.functionality.timer_functionality.presetTimeFunctionality
import com.timerpro.casualtimer.presentation.screen_slider_presentation.ScreenSlider
import com.timerpro.casualtimer.presentation.stopwatch_presentation.StopwatchScreen
import com.timerpro.casualtimer.presentation.timer_presentation.time_selection_screen.TimeSelectionScreen


class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
           permissionFunctionality.requestNotificationPermission(this@MainActivity) }

        setContent {

            // Configuration
            val configuration = LocalConfiguration.current

            // Screen Orientation
            val screenOrientation = remember { mutableIntStateOf(configuration.orientation) }

            // Nav Controller
            val navController = rememberNavController()

            // Initialize Alarm Sound Storage Files
            alarmSoundStorage.alarmSoundDirectory.mkdirs()
            alarmSoundStorage.alarmSoundFile.createNewFile()

            // Play Alarm
            alarmStateFunctionality.playAlarm(context = this@MainActivity, mediaPlayer = alarmPlayer.alarmPlayer)

            // Load All Preset Times
            presetTimeFunctionality.retrieveAllPresetTimes().observe(LocalLifecycleOwner.current) { timerStates.presetTimeList = it }

            // Portrait Casual Timer Home Screen Layout
            Scaffold(
                modifier = Modifier.padding(WindowInsets.systemBars.asPaddingValues()),
                bottomBar = {

                    ScreenSlider(
                        context = this@MainActivity,
                        configuration = configuration,
                        onClick = { generalFunctionality.transitionBetweenScreens(navController, this@MainActivity) },)
                }) {

                // Portrait Screen Transition Logic
                NavHost(navController = navController, sharedStates.startDestination) {

                    // Transition To Portrait Stopwatch Screen
                    composable("Stopwatch Screen",
                        deepLinks = listOf(navDeepLink {
                            uriPattern = sharedStates.fullStopwatchScreenDeepLinkUri
                            action = Intent.ACTION_VIEW
                        }),
                        enterTransition = { slideInHorizontally(initialOffsetX = { -it }) },
                        exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) }) {
                        StopwatchScreen(
                            context = this@MainActivity,
                            configuration = configuration,
                            screenOrientation = screenOrientation.intValue
                        )
                    }

                    // Transition To Portrait Time Selection Screen
                    composable("Time Selection Screen",
                        deepLinks = listOf(navDeepLink {
                            uriPattern = sharedStates.fullTimeSelectionScreenDeepLinkUri
                            action = Intent.ACTION_VIEW
                        }),
                        enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
                        exitTransition = { slideOutHorizontally(targetOffsetX = { it }) }) {
                        TimeSelectionScreen(
                            context = this@MainActivity,
                            configuration = configuration,
                            screenOrientation = screenOrientation.intValue,
                            alarmPlayer = alarmPlayer.alarmPlayer)
                    }}
            } }}}



