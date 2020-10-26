package com.flpereira.tmdbclient.presentation.di.core

import com.flpereira.tmdbclient.data.repository.artists.datasource.ArtistCacheDatasource
import com.flpereira.tmdbclient.data.repository.artists.datasourceimpl.ArtistCacheDataSourceImpl
import com.flpereira.tmdbclient.data.repository.movies.datasource.MovieCacheDatasource
import com.flpereira.tmdbclient.data.repository.movies.datasourceimpl.MovieCacheDataSourceImpl
import com.flpereira.tmdbclient.data.repository.tvshows.datasource.TvShowCacheDatasource
import com.flpereira.tmdbclient.data.repository.tvshows.datasourceimpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDatasource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDatasource {
        return ArtistCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDatasource {
        return TvShowCacheDataSourceImpl()
    }
}