package com.example.chessmate.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chessmate.data.cache.StatsCacheEntity

@Dao
interface StatsCacheDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(player: StatsCacheEntity)

    @Query("SELECT * FROM stats_cache WHERE username = :username")
    suspend fun getPlayerByUsername(username: String): StatsCacheEntity?
}