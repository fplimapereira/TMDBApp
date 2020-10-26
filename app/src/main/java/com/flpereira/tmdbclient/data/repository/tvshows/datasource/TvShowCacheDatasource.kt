package com.flpereira.tmdbclient.data.repository.tvshows.datasource

import com.flpereira.tmdbclient.data.model.tv.TvShow

interface TvShowCacheDatasource {

    suspend fun getTvShowsFromCache(): List<TvShow>

    suspend fun saveTvShowsToCache(tvShows: List<TvShow>)
}