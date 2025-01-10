package com.example.chessmate.data.remote.dto

import com.google.gson.annotations.SerializedName

class GameDto {
    @SerializedName("rating")
    var rating: Int? = 0

    @SerializedName("date")
    var date: Int? = 0

}
