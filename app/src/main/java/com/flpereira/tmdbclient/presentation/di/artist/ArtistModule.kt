package com.flpereira.tmdbclient.presentation.di.artist

import com.flpereira.tmdbclient.domain.usecase.artistuc.GetArtistsUseCase
import com.flpereira.tmdbclient.domain.usecase.artistuc.UpdateArtistsUseCase
import com.flpereira.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(getArtistsUseCase: GetArtistsUseCase,
    updateArtistsUseCase: UpdateArtistsUseCase): ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}