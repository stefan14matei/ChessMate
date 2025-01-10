package com.example.chessmate.data.remote.dto

import com.google.gson.annotations.SerializedName

class StatsDto {
    @SerializedName("chess_Rapid")
    var chessRapid: GameTypeDto? = null

    @SerializedName("chess_Bullet")
    var chessBullet: GameTypeDto? = null

    @SerializedName("chess_Blitz")
    var chessBlitz: GameTypeDto? = null

    @SerializedName("fide")
    var fide: Int? = null
}
