package com.example.nearbyapp.database

import android.content.Context
import com.example.nearbyapp.database.NearbyDatabaseReo
import com.example.nearbyapp.models.Venues

object NearbyDatabaseRepo {
    fun getNearbyRepos(context: Context) : List<Venues>{
        return NearbyDatabaseReo.getInstance(context).getNearbyRepos().getAllRepos()
    }

    fun addNearbyRepos(context: Context,data : List<Venues>){
        NearbyDatabaseReo.getInstance(context).getNearbyRepos().addNearbyRepos(data)
    }
}