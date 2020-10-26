package com.flpereira.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.flpereira.tmdbclient.data.model.artists.Artist
import com.flpereira.tmdbclient.domain.usecase.artistuc.GetArtistsUseCase
import com.flpereira.tmdbclient.domain.usecase.artistuc.UpdateArtistsUseCase


class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase): ViewModel() {

    fun getArtists() = liveData {
        val artistList: List<Artist>? = getArtistsUseCase.execute()
        emit(artistList)
    }

    fun updateArtists() = liveData {
        val artistList: List<Artist>? = updateArtistsUseCase.execute()
        emit(artistList)
    }
}
