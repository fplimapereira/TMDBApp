package com.flpereira.tmdbclient.data.repository.artists.datasourceimpl

import com.flpereira.tmdbclient.data.db.ArtistsDao
import com.flpereira.tmdbclient.data.model.artists.Artist
import com.flpereira.tmdbclient.data.repository.artists.datasource.ArtistLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistsDao: ArtistsDao):
    ArtistLocalDatasource {
    override suspend fun getArtistsFromDB(): List<Artist> = artistsDao.getAllArtists()


    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistsDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistsDao.deleteAllArtists()
        }
    }
}