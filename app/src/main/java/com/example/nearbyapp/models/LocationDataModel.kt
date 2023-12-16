package com.example.nearbyapp.models

import com.google.gson.annotations.SerializedName


data class LocationDataModel(

    @SerializedName("venues") var venues: ArrayList<Venues> = arrayListOf(),
    @SerializedName("meta") var meta: Meta? = Meta()

)