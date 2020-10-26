package com.flpereira.tmdbclient.data.repository.tvshows.datasource

import com.flpereira.tmdbclient.data.model.tv.TvShow

interface TvShowLocalDatasource {

    suspend fun getTvShowsFromDB(): List<TvShow>

    suspend fun saveTvShowsToDB(tvShows: List<TvShow>)

    suspend fun clearAll()
}