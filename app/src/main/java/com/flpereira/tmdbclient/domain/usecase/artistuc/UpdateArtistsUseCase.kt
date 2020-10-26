package com.flpereira.tmdbclient.domain.usecase.artistuc

import com.flpereira.tmdbclient.data.model.artists.Artist
import com.flpereira.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}