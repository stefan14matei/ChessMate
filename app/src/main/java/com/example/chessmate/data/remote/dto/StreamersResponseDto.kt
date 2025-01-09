package com.example.chessmate.data.remote.dto

import com.google.gson.annotations.SerializedName

data class StreamersResponseDto (
    @SerializedName("streamers")
    val streamers: List<StreamerDto>
)