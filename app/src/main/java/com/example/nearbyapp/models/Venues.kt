package com.example.nearbyapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "venues")
data class Venues(

    @PrimaryKey(autoGenerate = true)
    val uuid : Int = 0,
    @SerializedName("state") var state: String? = null,
    @SerializedName("name_v2") var nameV2: String? = null,
    @SerializedName("postal_code") var postalCode: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("timezone") var timezone: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("score") var score: Int? = null,
    @SerializedName("address") var address: String? = null,
    @SerializedName("country") var country: String? = null,
    @SerializedName("has_upcoming_events") var hasUpcomingEvents: Boolean? = null,
    @SerializedName("num_upcoming_events") var numUpcomingEvents: Int? = null,
    @SerializedName("city") var city: String? = null,
    @SerializedName("slug") var slug: String? = null,
    @SerializedName("extended_address") var extendedAddress: String? = null,
    @SerializedName("id") var id: Int? = null,
    @SerializedName("popularity") var popularity: Int? = null,
    @SerializedName("access_method") var accessMethod: String? = null,
    @SerializedName("metro_code") var metroCode: Int? = null,
    @SerializedName("capacity") var capacity: Int? = null,
    @SerializedName("display_location") var displayLocation: String? = null

)