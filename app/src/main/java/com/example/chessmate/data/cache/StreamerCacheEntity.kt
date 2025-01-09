package com.example.chessmate.data.cache

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "streamer_cache")
data class StreamerCacheEntity(
    @PrimaryKey(autoGenerate = false)
    val username: String,
    val avatar: String?,
    val isCommunityStreamer: Boolean,
    val isLive: Boolean,
    val twitchUrl: String?,
    val url: String?
)
