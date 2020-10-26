package com.flpereira.tmdbclient.data.repository.tvshows.datasourceimpl

import com.flpereira.tmdbclient.data.db.TvShowsDao
import com.flpereira.tmdbclient.data.model.tv.TvShow
import com.flpereira.tmdbclient.data.repository.tvshows.datasource.TvShowLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowsDao: TvShowsDao):
    TvShowLocalDatasource {

    override suspend fun getTvShowsFromDB(): List<TvShow> = tvShowsDao.getAllTvShows()


    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowsDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowsDao.deleteAllTvShows()
        }
    }
}