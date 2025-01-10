package com.example.chessmate.data.remote.dto

import com.google.gson.annotations.SerializedName

class GameDto {
    @SerializedName("rating")
    var rating: Int? = null

    @SerializedName("date")
    var date: Int? = null
}
