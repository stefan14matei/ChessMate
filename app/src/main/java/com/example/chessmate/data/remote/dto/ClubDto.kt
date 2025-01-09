package com.example.chessmate.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ClubDto(
    @SerializedName("@id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("last_activity")
    val lastActivity: Long,

    @SerializedName("icon")
    val icon: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("joined")
    val joined: Long
)