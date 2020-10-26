package com.flpereira.tmdbclient.data.model.artists


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_artists")
data class Artist(
    val name: String,
    @PrimaryKey
    val id: Int,
    @SerializedName("profile_path")
    val profilePath: String

)