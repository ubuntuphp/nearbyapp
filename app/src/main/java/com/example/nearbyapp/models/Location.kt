package com.example.nearbyapp.models

import com.google.gson.annotations.SerializedName


data class Location(

    @SerializedName("lat") var lat: Double? = null,
    @SerializedName("lon") var lon: Double? = null

)