package com.flpereira.tmdbclient.presentation.di.artist

import com.flpereira.tmdbclient.presentation.artist.ArtistActivity
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {

    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory{

        fun create(): ArtistSubComponent
    }
}