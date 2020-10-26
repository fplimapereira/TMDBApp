package com.flpereira.tmdbclient.presentation.di.movie

import com.flpereira.tmdbclient.presentation.artist.ArtistActivity
import com.flpereira.tmdbclient.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{

        fun create(): MovieSubComponent
    }
}