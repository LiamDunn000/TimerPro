package com.timerpro.timertest.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [PresetTime::class],
    version = 1
)
abstract class PresetTimeDatabase: RoomDatabase() {
    abstract val presetTimeDao: PresetTimeDao

    companion object {
        lateinit var instance: PresetTimeDatabase
    }
}

val presetTimeDatabase: PresetTimeDatabase by lazy { PresetTimeDatabase.instance }