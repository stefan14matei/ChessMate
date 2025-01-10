package com.example.chessmate.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chessmate.data.cache.PlayerCacheEntity

@Dao
interface PlayerCacheDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(player: PlayerCacheEntity)

    @Query("SELECT * FROM player_cache WHERE username = :username")
    suspend fun getPlayerByUsername(username: String): PlayerCacheEntity?
}
