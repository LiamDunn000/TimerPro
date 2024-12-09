package com.timerpro.timertest.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PresetTime(

    val name: String = "",
    val hours: Int = 0,
    val minutes: Int = 0,
    val seconds: Int = 0,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)