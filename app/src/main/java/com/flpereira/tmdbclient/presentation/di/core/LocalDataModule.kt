package com.flpereira.tmdbclient.presentation.di.core

import com.flpereira.tmdbclient.data.db.ArtistsDao
import com.flpereira.tmdbclient.data.db.MoviesDao
import com.flpereira.tmdbclient.data.db.TvShowsDao
import com.flpereira.tmdbclient.data.repository.artists.datasource.ArtistLocalDatasource
import com.flpereira.tmdbclient.data.repository.artists.datasourceimpl.ArtistLocalDataSourceImpl
import com.flpereira.tmdbclient.data.repository.movies.datasource.MovieLocalDatasource
import com.flpereira.tmdbclient.data.repository.movies.datasourceimpl.MovieLocalDataSourceImpl
import com.flpereira.tmdbclient.data.repository.tvshows.datasource.TvShowLocalDatasource
import com.flpereira.tmdbclient.data.repository.tvshows.datasourceimpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(moviesDao: MoviesDao): MovieLocalDatasource{
        return MovieLocalDataSourceImpl(moviesDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistsDao: ArtistsDao): ArtistLocalDatasource {
        return ArtistLocalDataSourceImpl(artistsDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowsDao: TvShowsDao): TvShowLocalDatasource {
        return TvShowLocalDataSourceImpl(tvShowsDao)
    }
}