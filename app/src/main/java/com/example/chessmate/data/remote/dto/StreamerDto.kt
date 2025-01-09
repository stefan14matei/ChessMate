package com.example.chessmate.data.remote.dto

import com.google.gson.annotations.SerializedName

data class StreamerDto(
    @SerializedName("avatar")
    val avatar: String,

    @SerializedName("is_community_name")
    val isCommunityStreamer: Boolean,

    @SerializedName("is_live")
    val isLive: Boolean,

    @SerializedName("platforms")
    val platformDtos: List<PlatformDto>,

    @SerializedName("twitch_url")
    val twitchUrl: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("username")
    val username: String
)