package com.example.chessmate.data.remote.dto

import com.google.gson.annotations.SerializedName

class RecordDto {
    @SerializedName("win")
    var win: Int? = null

    @SerializedName("loss")
    var loss: Int? = null

    @SerializedName("draw")
    var draw: Int? = null
}
