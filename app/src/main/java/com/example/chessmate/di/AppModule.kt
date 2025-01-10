package com.example.chessmate.di

import com.example.chessmate.common.Constants
import com.example.chessmate.data.cache.dao.PlayerCacheDao
import com.example.chessmate.data.cache.dao.StreamerCacheDao
import com.example.chessmate.data.remote.ChessApi
import com.example.chessmate.repository.StreamerRepositoryImpl
import com.example.chessmate.domain.repository.StreamerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesChessApi(): ChessApi {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ChessApi::class.java)
    }

    @Provides
    @Singleton
    fun provideStreamerRepository(api: ChessApi, streamerCacheDao: StreamerCacheDao, playerCacheDao: PlayerCacheDao): StreamerRepository{
        return StreamerRepositoryImpl(streamerCacheDao, playerCacheDao, api)
    }
}