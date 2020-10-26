package com.flpereira.tmdbclient.data.model.artists


import com.google.gson.annotations.SerializedName

data class ArtistList(
    val page: Int,
    @SerializedName("results")
    val artists: List<Artist>
)