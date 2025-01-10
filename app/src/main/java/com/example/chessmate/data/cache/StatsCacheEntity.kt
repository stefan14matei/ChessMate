package com.example.chessmate.data.cache

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stats_cache")
data class StatsCacheEntity(
    @PrimaryKey(autoGenerate = false)
    val username: String,
    val rapidRating: Int,
    val bulletRating: Int,
    val blitzRating: Int,
    val rapidWins: Int,
    val bulletWins: Int,
    val blitzWins: Int,
    val rapidLosses: Int,
    val bulletLosses: Int,
    val blitzLosses: Int,
    val rapidDraws: Int,
    val bulletDraws: Int,
    val blitzDraws: Int,
    val fideRating: Int
)
