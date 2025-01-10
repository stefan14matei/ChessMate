package com.example.chessmate.database

import android.content.Context
import androidx.room.Room
import com.example.chessmate.data.cache.dao.PlayerCacheDao
import com.example.chessmate.data.cache.dao.StreamerCacheDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): StreamerCacheDatabase {
        return Room.databaseBuilder(
            context,
            StreamerCacheDatabase::class.java,
            "cache-database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideStreamerCacheDao(database: StreamerCacheDatabase): StreamerCacheDao {
        return database.streamerCacheDao()
    }

    @Provides
    fun providePlayerCacheDao(database: StreamerCacheDatabase): PlayerCacheDao {
        return database.playerCacheDao()
    }
}