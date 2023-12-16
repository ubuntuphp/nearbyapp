package com.example.nearbyapp.models

import com.google.gson.annotations.SerializedName


data class Meta(

    @SerializedName("total") var total: Int? = null,
    @SerializedName("took") var took: Int? = null,
    @SerializedName("page") var page: Int? = null,
    @SerializedName("per_page") var perPage: Int? = null,
    @SerializedName("geolocation") var geolocation: Geolocation? = Geolocation()

)