package com.timerpro.timertest.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PresetTime(

    val name: String,
    val hours: Int,
    val minutes: Int,
    val seconds: Int,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)