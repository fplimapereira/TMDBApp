package com.flpereira.tmdbclient.data.repository.artists.datasource

import com.flpereira.tmdbclient.data.model.artists.Artist

interface ArtistCacheDatasource {

    suspend fun getArtistsFromCache(): List<Artist>

    suspend fun saveArtistsToCache(movies: List<Artist>)
}