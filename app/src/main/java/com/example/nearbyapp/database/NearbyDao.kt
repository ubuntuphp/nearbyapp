package com.example.nearbyapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.nearbyapp.models.Venues

@Dao
interface NearbyDao  {
    @Insert
    fun addNearbyRepos(dao: List<Venues>)

    @Query("SELECT * FROM venues")
    fun getAllRepos(): List<Venues>
}