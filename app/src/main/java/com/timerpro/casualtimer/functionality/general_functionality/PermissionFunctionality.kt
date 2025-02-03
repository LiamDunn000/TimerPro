package com.timerpro.casualtimer.functionality.general_functionality

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat

val permissionFunctionality = PermissionFunctionality()

class PermissionFunctionality {

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    fun requestNotificationPermission(context: Context) {
        ActivityCompat.requestPermissions(context as android.app.Activity,
            arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),
            100
        )
    }

    private fun requestExternalStorePermission(context: Context) {
        ActivityCompat.requestPermissions(context as android.app.Activity,
            arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
            100
        )
    }

    private fun requestAudioFilePermission(context: Context) {
        ActivityCompat.requestPermissions(context as android.app.Activity,
            arrayOf(android.Manifest.permission.READ_MEDIA_AUDIO),
            100
        )
    }

    fun manageAudioFilePermissionRequests(context: Context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            requestExternalStorePermission(context = context) }

        requestAudioFilePermission(context = context)
    }

}