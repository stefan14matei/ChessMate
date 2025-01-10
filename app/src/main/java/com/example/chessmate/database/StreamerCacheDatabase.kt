package com.example.chessmate.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.chessmate.data.cache.PlayerCacheEntity
import com.example.chessmate.data.cache.StatsCacheEntity
import com.example.chessmate.data.cache.StreamerCacheEntity
import com.example.chessmate.data.cache.dao.PlayerCacheDao
import com.example.chessmate.data.cache.dao.StatsCacheDao
import com.example.chessmate.data.cache.dao.StreamerCacheDao

@Database(
    entities = [
        StreamerCacheEntity::class,
        PlayerCacheEntity::class,
        StatsCacheEntity::class
    ], version = 4
)
abstract class StreamerCacheDatabase : RoomDatabase() {
    abstract fun streamerCacheDao(): StreamerCacheDao
    abstract fun playerCacheDao(): PlayerCacheDao
    abstract fun statsCacheDao(): StatsCacheDao
}