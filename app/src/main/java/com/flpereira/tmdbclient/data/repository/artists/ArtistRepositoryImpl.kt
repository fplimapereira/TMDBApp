package com.flpereira.tmdbclient.data.repository.artists

import android.util.Log
import com.flpereira.tmdbclient.data.model.artists.Artist
import com.flpereira.tmdbclient.data.model.artists.ArtistList

import com.flpereira.tmdbclient.data.repository.artists.datasource.ArtistCacheDatasource
import com.flpereira.tmdbclient.data.repository.artists.datasource.ArtistLocalDatasource
import com.flpereira.tmdbclient.data.repository.artists.datasource.ArtistRemoteDatasource
import com.flpereira.tmdbclient.domain.repository.ArtistRepository
import retrofit2.Response
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistLocalDatasource: ArtistLocalDatasource,
    private val artistCacheDatasource: ArtistCacheDatasource
): ArtistRepository {

    override suspend fun getArtists(): List<Artist>? = getArtistsFromCache()

    override suspend fun updateArtists(): List<Artist>? {
       val newListOfArtists: List<Artist> = getArtistsFromAPI()
        artistLocalDatasource.clearAll()
        artistLocalDatasource.saveArtistsToDB(newListOfArtists)
        artistCacheDatasource.saveArtistsToCache(newListOfArtists)

        return newListOfArtists
    }

    suspend fun getArtistsFromAPI(): List<Artist>{
        lateinit var artistsList:List<Artist>
        try {
            val response: Response<ArtistList> = artistRemoteDatasource.getArtists()
            val body: ArtistList? = response.body()
            if (body!=null){
                artistsList = body.artists
            }
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        return artistsList
    }

    suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistsList:List<Artist>
        try {
            artistsList = artistLocalDatasource.getArtistsFromDB()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if (artistsList.isNotEmpty()){
            return artistsList
        }else{
            artistsList = getArtistsFromAPI()
            artistLocalDatasource.saveArtistsToDB(artistsList)
        }
        return artistsList
    }

    suspend fun getArtistsFromCache(): List<Artist>{
        lateinit var artistsList:List<Artist>
        try {
            artistsList =artistCacheDatasource.getArtistsFromCache()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if (artistsList.isNotEmpty()){
            return artistsList
        }else{
            artistsList = getArtistsFromDB()
            artistCacheDatasource.saveArtistsToCache(artistsList)
        }
        return artistsList
    }
}