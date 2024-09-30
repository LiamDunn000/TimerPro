package com.timerpro.casualtimer

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.core.app.ActivityCompat
import com.timerpro.casualtimer.presentation.casual_timer_screen_presentation.casual_timer_screen_layouts.CasualTimerScreen


class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestNotificationPermission(this@MainActivity) }

        setContent {

            // Configuration
            val configuration = LocalConfiguration.current

            // Screen Orientation
            val screenOrientation = remember { mutableIntStateOf(configuration.orientation) }

            // Casual Timer Screen
            CasualTimerScreen(
                context = this@MainActivity,
                configuration = configuration,
                screenOrientation = screenOrientation.intValue) }}}



@RequiresApi(Build.VERSION_CODES.TIRAMISU)
fun requestNotificationPermission(context: Context) {
    ActivityCompat.requestPermissions(context as android.app.Activity,
        arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),
        100
    )
}