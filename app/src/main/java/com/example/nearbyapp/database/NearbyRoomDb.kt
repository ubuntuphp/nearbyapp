package com.example.nearbyapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nearbyapp.models.Venues

@Database(entities = [Venues::class], version = 1)
abstract class NearbyDatabaseReo : RoomDatabase() {
    abstract fun getNearbyRepos(): NearbyDao

    companion object {
        private lateinit var instance: NearbyDatabaseReo
        fun getInstance(context: Context): NearbyDatabaseReo {
            if (Companion::instance.isInitialized) return instance
            instance =
                Room.databaseBuilder(context, NearbyDatabaseReo::class.java, "nearby_db").build()
            return instance
        }
    }

}