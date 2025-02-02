package com.example.kotlin63.data.remote.models.mangamodels

import com.google.gson.annotations.SerializedName

data class Data(@SerializedName("relationships")
                val relationships: Relationships,
                @SerializedName("links")
                val links: Links,
                @SerializedName("attributes")
                val attributes: Attributes,
                @SerializedName("id")
                val id: String = "",
                @SerializedName("type")
                val type: String = "")