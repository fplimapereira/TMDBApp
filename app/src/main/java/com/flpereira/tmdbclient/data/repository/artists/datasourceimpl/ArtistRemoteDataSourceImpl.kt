package com.flpereira.tmdbclient.data.repository.artists.datasourceimpl

import com.flpereira.tmdbclient.data.api.TMDBService
import com.flpereira.tmdbclient.data.model.artists.ArtistList
import com.flpereira.tmdbclient.data.repository.artists.datasource.ArtistRemoteDatasource

import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String):
    ArtistRemoteDatasource {

    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)
}