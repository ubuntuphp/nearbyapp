package com.example.nearbyapp.repos

import com.example.nearbyapp.models.LocationDataModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/2/venues?client_id=Mzg0OTc0Njl8MTcwMDgxMTg5NC44MDk2NjY5")
    fun fetchLocation(
        @Query("page")
        page:Int = 1,
        @Query("lat")
        lat:String,
        @Query("lon")
        long:String,
        @Query("range")
        range:String = "12mi"
        ) : Call<LocationDataModel>
}