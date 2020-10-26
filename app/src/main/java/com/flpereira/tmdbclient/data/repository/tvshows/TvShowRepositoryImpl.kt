package com.flpereira.tmdbclient.data.repository.tvshows

import android.util.Log
import com.flpereira.tmdbclient.data.model.tv.TvShow
import com.flpereira.tmdbclient.data.model.tv.TvShowList
import com.flpereira.tmdbclient.data.repository.tvshows.datasource.TvShowCacheDatasource
import com.flpereira.tmdbclient.data.repository.tvshows.datasource.TvShowLocalDatasource
import com.flpereira.tmdbclient.data.repository.tvshows.datasource.TvShowRemoteDatasource
import com.flpereira.tmdbclient.domain.repository.TvShowRepository
import retrofit2.Response
import java.lang.Exception

class TvShowRepositoryImpl(
    private val tvShowRemoteDatasource: TvShowRemoteDatasource,
    private val tvShowLocalDatasource: TvShowLocalDatasource,
    private val tvShowCacheDatasource: TvShowCacheDatasource
): TvShowRepository {

    override suspend fun getTvShows(): List<TvShow>? = getTvShowsFromCache()

    override suspend fun updateTvShows(): List<TvShow>? {
       val newListOfTvShows: List<TvShow> = getTvShowsFromAPI()
        tvShowLocalDatasource.clearAll()
        tvShowLocalDatasource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDatasource.saveTvShowsToCache(newListOfTvShows)

        return newListOfTvShows
    }

    suspend fun getTvShowsFromAPI(): List<TvShow>{
        lateinit var tvShowsList:List<TvShow>
        try {
            val response: Response<TvShowList> = tvShowRemoteDatasource.getTvShows()
            val body: TvShowList? = response.body()
            if (body!=null){
                tvShowsList = body.tvShows
            }
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        return tvShowsList
    }

    suspend fun getTvShowsFromDB(): List<TvShow> {
        lateinit var tvShowsList:List<TvShow>
        try {
            tvShowsList = tvShowLocalDatasource.getTvShowsFromDB()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if (tvShowsList.isNotEmpty()){
            return tvShowsList
        }else{
            tvShowsList = getTvShowsFromAPI()
           tvShowLocalDatasource.saveTvShowsToDB(tvShowsList)
        }
        return tvShowsList
    }

    suspend fun getTvShowsFromCache(): List<TvShow>{
        lateinit var tvShowsList:List<TvShow>
        try {
            tvShowsList = tvShowCacheDatasource.getTvShowsFromCache()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if (tvShowsList.isNotEmpty()){
            return tvShowsList
        }else{
            tvShowsList = getTvShowsFromDB()
            tvShowCacheDatasource.saveTvShowsToCache(tvShowsList)
        }
        return tvShowsList
    }
}