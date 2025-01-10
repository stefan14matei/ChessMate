package com.example.chessmate.data.cache

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player_cache")
data class PlayerCacheEntity (
    @PrimaryKey(autoGenerate = false)
    var username: String,
    var avatar: String?,
    var country: String?,
    var followers: Int?,
    var isStreamer: Boolean?,
    var joined: Int?,
    var lastOnline: Int?,
    var league: String?,
    var location: String?,
    var name: String?,
    var status: String?,
    var title: String?,
    var twitchUrl: String?,
    var url: String?,
    var verified: Boolean?
)