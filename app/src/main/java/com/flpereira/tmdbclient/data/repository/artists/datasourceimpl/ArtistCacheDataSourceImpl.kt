package com.flpereira.tmdbclient.data.repository.artists.datasourceimpl

import com.flpereira.tmdbclient.data.model.artists.Artist
import com.flpereira.tmdbclient.data.repository.artists.datasource.ArtistCacheDatasource

class ArtistCacheDataSourceImpl:
    ArtistCacheDatasource {

    private var artistsList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> = artistsList


    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistsList.clear()
        artistsList = ArrayList(artists)
    }

}