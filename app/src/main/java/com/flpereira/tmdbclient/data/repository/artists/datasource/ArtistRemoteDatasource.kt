package com.flpereira.tmdbclient.data.repository.artists.datasource

import com.flpereira.tmdbclient.data.model.artists.ArtistList

import retrofit2.Response

interface ArtistRemoteDatasource {

    suspend fun getArtists(): Response<ArtistList>
}