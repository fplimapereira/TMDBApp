package com.flpereira.tmdbclient.data.repository.artists.datasource

import com.flpereira.tmdbclient.data.model.artists.Artist
import com.flpereira.tmdbclient.data.model.movies.Movie

interface ArtistLocalDatasource {

    suspend fun getArtistsFromDB(): List<Artist>

    suspend fun saveArtistsToDB(movies: List<Artist>)

    suspend fun clearAll()
}