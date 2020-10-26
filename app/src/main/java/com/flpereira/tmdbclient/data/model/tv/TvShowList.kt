package com.flpereira.tmdbclient.data.model.tv


import com.google.gson.annotations.SerializedName

data class TvShowList(
    val page: Int,
    @SerializedName("results")
    val tvShows: List<TvShow>
)