package com.example.chessmate.data.remote.dto


import com.google.gson.annotations.SerializedName

data class PlayerDto(
    @SerializedName("avatar")
    val avatar: String,

    @SerializedName("country")
    val country: String,

    @SerializedName("followers")
    val followers: Int,

    @SerializedName("@id")
    val id: String,

    @SerializedName("is_streamer")
    val isStreamer: Boolean,

    @SerializedName("joined")
    val joined: Int,

    @SerializedName("last_online")
    val lastOnline: Int,

    @SerializedName("league")
    val league: String,

    @SerializedName("location")
    val location: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("player_id")
    val playerId: Int,

    @SerializedName("status")
    val status: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("twitch_url")
    val twitchUrl: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("username")
    val username: String,

    @SerializedName("verified")
    val verified: Boolean
)