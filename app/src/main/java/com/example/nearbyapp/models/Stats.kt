package com.example.nearbyapp.models

import com.google.gson.annotations.SerializedName


data class Stats(

    @SerializedName("event_count") var eventCount: Int? = null

)