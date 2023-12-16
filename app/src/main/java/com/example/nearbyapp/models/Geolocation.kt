package com.example.nearbyapp.models

import com.google.gson.annotations.SerializedName


data class Geolocation(

    @SerializedName("lat") var lat: Double? = null,
    @SerializedName("lon") var lon: Double? = null,
    @SerializedName("city") var city: String? = null,
    @SerializedName("state") var state: String? = null,
    @SerializedName("country") var country: String? = null,
    @SerializedName("postal_code") var postalCode: String? = null,
    @SerializedName("display_name") var displayName: String? = null,
    @SerializedName("metro_code") var metroCode: String? = null,
    @SerializedName("range") var range: String? = null

)