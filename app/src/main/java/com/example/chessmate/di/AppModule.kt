package com.example.chessmate.di

import com.example.chessmate.common.Constants
import com.example.chessmate.data.remote.ChessApi
import com.example.chessmate.data.repository.StreamerRepositoryImpl
import com.example.chessmate.domain.repository.StreamerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesChessApi(): ChessApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ChessApi::class.java)
    }

    @Provides
    @Singleton
    fun provideStreamerRepository(api: ChessApi): StreamerRepository{
        return StreamerRepositoryImpl(api)
    }
}