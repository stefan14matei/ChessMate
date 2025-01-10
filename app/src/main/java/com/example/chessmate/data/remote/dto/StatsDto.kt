package com.example.chessmate.data.remote.dto

import com.google.gson.annotations.SerializedName

class StatsDto {
    @SerializedName("chess_rapid")
    var chessRapid: GameTypeDto? = null

    @SerializedName("chess_bullet")
    var chessBullet: GameTypeDto? = null

    @SerializedName("chess_blitz")
    var chessBlitz: GameTypeDto? = null

    @SerializedName("fide")
    var fide: Int? = 0
}
