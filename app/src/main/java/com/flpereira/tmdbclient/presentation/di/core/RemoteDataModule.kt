package com.flpereira.tmdbclient.presentation.di.core

import com.flpereira.tmdbclient.data.api.TMDBService
import com.flpereira.tmdbclient.data.repository.artists.datasource.ArtistRemoteDatasource
import com.flpereira.tmdbclient.data.repository.artists.datasourceimpl.ArtistRemoteDataSourceImpl
import com.flpereira.tmdbclient.data.repository.movies.datasource.MovieRemoteDatasource
import com.flpereira.tmdbclient.data.repository.movies.datasourceimpl.MovieRemoteDataSourceImpl
import com.flpereira.tmdbclient.data.repository.tvshows.datasource.TvShowRemoteDatasource
import com.flpereira.tmdbclient.data.repository.tvshows.datasourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDatasource{
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDatasource {
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDatasource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }
}