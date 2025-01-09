package com.example.chessmate.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chessmate.data.cache.StreamerCacheEntity

@Dao
interface StreamerCacheDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(streamer: StreamerCacheEntity)

    @Query("SELECT * FROM streamer_cache WHERE username = :username")
    suspend fun getStreamerById(username: String): StreamerCacheEntity?

    @Query("SELECT * FROM streamer_cache")
    suspend fun getAllStreamers(): List<StreamerCacheEntity>

}