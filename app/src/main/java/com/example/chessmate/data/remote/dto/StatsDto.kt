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

    companion object {
        fun newInstance(statsCacheEntity: StatsCacheEntity): StatsDto {
            return StatsDto().apply {
                chessRapid = GameTypeDto().apply {
                    last = GameDto().apply {
                        rating = statsCacheEntity.rapidRating
                    }
                    best = GameDto().apply {
                        rating = statsCacheEntity.rapidRating
                    }
                    record = RecordDto().apply {
                        win = statsCacheEntity.rapidWins
                        loss = statsCacheEntity.rapidLosses
                        draw = statsCacheEntity.rapidDraws
                    }
                }
                chessBullet = GameTypeDto().apply {
                    last = GameDto().apply {
                        rating = statsCacheEntity.bulletRating
                    }
                    best = GameDto().apply {
                        rating = statsCacheEntity.bulletRating
                    }
                    record = RecordDto().apply {
                        win = statsCacheEntity.bulletWins
                        loss = statsCacheEntity.bulletLosses
                        draw = statsCacheEntity.bulletDraws
                    }
                }
                chessBlitz = GameTypeDto().apply {
                    last = GameDto().apply {
                        rating = statsCacheEntity.blitzRating
                    }
                    best = GameDto().apply {
                        rating = statsCacheEntity.blitzRating
                    }
                    record = RecordDto().apply {
                        win = statsCacheEntity.blitzWins
                        loss = statsCacheEntity.blitzLosses
                        draw = statsCacheEntity.blitzDraws
                    }
                }
                fide = statsCacheEntity.fideRating
            }
        }

        fun emptyInstance(): StatsDto {
            return StatsDto().apply {
                chessRapid = GameTypeDto().apply {
                    last = GameDto().apply {
                        rating = 0
                    }
                    best = GameDto().apply {
                        rating = 0
                    }
                    record = RecordDto().apply {
                        win = 0
                        loss = 0
                        draw = 0
                    }
                }
                chessBullet = GameTypeDto().apply {
                    last = GameDto().apply {
                        rating = 0
                    }
                    best = GameDto().apply {
                        rating = 0

                    }
                    record = RecordDto().apply {
                        win = 0
                        loss = 0
                        draw = 0
                    }
                }
                chessBlitz = GameTypeDto().apply {
                    last = GameDto().apply {
                        rating = 0
                    }
                    best = GameDto().apply {
                        rating = 0
                    }
                    record = RecordDto().apply {
                        win = 0
                        loss = 0
                        draw = 0
                    }
                }
                fide = 0
            }
        }
    }
}
