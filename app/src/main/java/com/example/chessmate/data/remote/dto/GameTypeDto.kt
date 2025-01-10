package com.example.chessmate.data.remote.dto

import com.google.gson.annotations.SerializedName

class GameTypeDto {
    @SerializedName("last")
    var last: GameDto? = null

    @SerializedName("best")
    var best: GameDto? = null

    @SerializedName("record")
    var record: RecordDto? = null
}
