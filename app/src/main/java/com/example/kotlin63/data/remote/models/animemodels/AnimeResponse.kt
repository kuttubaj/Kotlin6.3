package com.example.kotlin63.data.remote.models.animemodels

import com.google.gson.annotations.SerializedName

data class AnimeResponse(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("links")
    val links: LinksXXXXXXXXXXXXX,
    @SerializedName("meta")
    val meta: MetaXX
)