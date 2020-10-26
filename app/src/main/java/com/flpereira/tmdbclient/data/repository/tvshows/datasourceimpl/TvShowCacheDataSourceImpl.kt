package com.flpereira.tmdbclient.data.repository.tvshows.datasourceimpl

import com.flpereira.tmdbclient.data.model.tv.TvShow
import com.flpereira.tmdbclient.data.repository.tvshows.datasource.TvShowCacheDatasource


class TvShowCacheDataSourceImpl: TvShowCacheDatasource {

    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> = tvShowList


    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }

}