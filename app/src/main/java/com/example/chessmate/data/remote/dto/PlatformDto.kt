package com.example.chessmate.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PlatformDto(
    @SerializedName("channel_url")
    val channelUrl: String,

    @SerializedName("is_live")
    val isLive: Boolean,

    @SerializedName("is_main_live_platform")
    val isMainLivePlatform: Boolean,

    @SerializedName("stream_url")
    val streamUrl: String,

    @SerializedName("type")
    val type: String
)