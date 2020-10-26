package com.flpereira.tmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.flpereira.tmdbclient.data.db.ArtistsDao
import com.flpereira.tmdbclient.data.db.MoviesDao
import com.flpereira.tmdbclient.data.db.TMDBDatabase
import com.flpereira.tmdbclient.data.db.TvShowsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesMovieDataBase(context: Context): TMDBDatabase{
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient")
            .build()
    }


    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MoviesDao{
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistsDao{
        return tmdbDatabase.artistDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TvShowsDao{
        return tmdbDatabase.tvShowDao()
    }
}