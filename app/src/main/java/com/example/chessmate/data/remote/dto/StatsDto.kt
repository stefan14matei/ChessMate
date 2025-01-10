package com.example.chessmate.data.remote.dto

import com.example.chessmate.data.cache.StatsCacheEntity
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

    fun toStatsCacheEntity(username: String): StatsCacheEntity {
        return StatsCacheEntity(
            username = username,
            rapidRating = chessRapid?.last?.rating ?: 0,
            bulletRating = chessBullet?.last?.rating ?: 0,
            blitzRating = chessBlitz?.last?.rating ?: 0,
            rapidWins = chessRapid?.record?.win ?: 0,
            bulletWins = chessBullet?.record?.win ?: 0,
            blitzWins = chessBlitz?.record?.win ?: 0,
            rapidLosses = chessRapid?.record?.loss ?: 0,
            bulletLosses = chessBullet?.record?.loss ?: 0,
            blitzLosses = chessBlitz?.record?.loss ?: 0,
            rapidDraws = chessRapid?.record?.draw ?: 0,
            bulletDraws = chessBullet?.record?.draw ?: 0,
            blitzDraws = chessBlitz?.record?.draw ?: 0,
            fideRating = fide ?: 0
        )
    }
}
