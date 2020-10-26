package com.flpereira.tmdbclient.presentation.di.core

import com.flpereira.tmdbclient.data.repository.artists.ArtistRepositoryImpl
import com.flpereira.tmdbclient.data.repository.artists.datasource.ArtistCacheDatasource
import com.flpereira.tmdbclient.data.repository.artists.datasource.ArtistLocalDatasource
import com.flpereira.tmdbclient.data.repository.artists.datasource.ArtistRemoteDatasource
import com.flpereira.tmdbclient.data.repository.movies.MovieRepositoryImpl
import com.flpereira.tmdbclient.data.repository.movies.datasource.MovieCacheDatasource
import com.flpereira.tmdbclient.data.repository.movies.datasource.MovieLocalDatasource
import com.flpereira.tmdbclient.data.repository.movies.datasource.MovieRemoteDatasource
import com.flpereira.tmdbclient.data.repository.tvshows.TvShowRepositoryImpl
import com.flpereira.tmdbclient.data.repository.tvshows.datasource.TvShowCacheDatasource
import com.flpereira.tmdbclient.data.repository.tvshows.datasource.TvShowLocalDatasource
import com.flpereira.tmdbclient.data.repository.tvshows.datasource.TvShowRemoteDatasource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDatasource: MovieLocalDatasource,
        movieCacheDatasource: MovieCacheDatasource
    ): MovieRepositoryImpl{

        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDatasource,
            movieCacheDatasource
        )
    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDatasource,
        artistLocalDatasource: ArtistLocalDatasource,
        artistCacheDatasource: ArtistCacheDatasource
    ): ArtistRepositoryImpl {

        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDatasource,
            artistCacheDatasource
        )
    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDatasource,
        tvShowLocalDatasource: TvShowLocalDatasource,
        tvShowCacheDatasource: TvShowCacheDatasource
    ): TvShowRepositoryImpl {

        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDatasource,
            tvShowCacheDatasource
        )
    }
}