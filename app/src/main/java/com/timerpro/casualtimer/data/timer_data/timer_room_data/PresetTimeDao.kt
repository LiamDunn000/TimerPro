package com.timerpro.timertest.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PresetTimeDao {

    // Insert Preset Time
    @Insert
    suspend fun insertPresetTime(presetTime: PresetTime)

    // Update Preset Time
    @Update
    suspend fun updatePresetTime(presetTime: PresetTime)

    // Delete Preset Time
    @Delete
    suspend fun deletePresetTime(presetTime: PresetTime)

    // Retrieve All Preset Times
    @Query("SELECT * FROM PresetTime")
    fun retrieveAllPresetTimes(): Flow<List<PresetTime>>
}