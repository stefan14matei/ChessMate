package com.example.chessmate.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.chessmate.data.cache.StreamerCacheEntity
import com.example.chessmate.data.cache.dao.StreamerCacheDao

@Database(entities = [StreamerCacheEntity::class], version = 2)
abstract class StreamerCacheDatabase : RoomDatabase() {
    abstract fun streamerCacheDao(): StreamerCacheDao

    companion object {
        @Volatile
        private var INSTANCE: StreamerCacheDatabase? = null

        fun getDatabase(context: Context): StreamerCacheDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StreamerCacheDatabase::class.java,
                    "streamer_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}