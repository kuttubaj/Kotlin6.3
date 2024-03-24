package com.example.kotlin63.data.remote.models.animemodels

import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("abbreviatedTitles")
    val abbreviatedTitles: List<String>,
    @SerializedName("ageRating")
    val ageRating: String,
    @SerializedName("ageRatingGuide")
    val ageRatingGuide: String,
    @SerializedName("averageRating")
    val averageRating: String,
    @SerializedName("canonicalTitle")
    val canonicalTitle: String,
    @SerializedName("coverImage")
    val coverImage: CoverImage,
    @SerializedName("coverImageTopOffset")
    val coverImageTopOffset: Int,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("endDate")
    val endDate: String,
    @SerializedName("episodeCount")
    val episodeCount: Int,
    @SerializedName("episodeLength")
    val episodeLength: Int,
    @SerializedName("favoritesCount")
    val favoritesCount: Int,
    @SerializedName("nsfw")
    val nsfw: Boolean,
    @SerializedName("popularityRank")
    val popularityRank: Int,
    @SerializedName("posterImage")
    val posterImage: PosterImage,
    @SerializedName("ratingFrequencies")
    val ratingFrequencies: RatingFrequencies,
    @SerializedName("ratingRank")
    val ratingRank: Int,
    @SerializedName("showType")
    val showType: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("startDate")
    val startDate: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("subType")
    val subtype: String,
    @SerializedName("synopsis")
    val synopsis: String,
    @SerializedName("tba")
    val tba: String,
    @SerializedName("titles")
    val titles: Titles,
    @SerializedName("updateAt")
    val updatedAt: String,
    @SerializedName("userCount")
    val userCount: Int,
    @SerializedName("youtubeVideoId")
    val youtubeVideoId: String
)