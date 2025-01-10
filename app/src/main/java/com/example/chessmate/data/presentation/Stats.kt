package com.example.chessmate.data.presentation

import com.example.chessmate.data.remote.dto.StatsDto

data class Stats (
    val chessRapid: GameType,
    val chessBullet: GameType,
    val chessBlitz: GameType,
    val fideRating: Int
) {
    companion object {
        fun newInstance(playerStats: StatsDto): Stats {
            return Stats(
                chessRapid = GameType.newInstance(playerStats.chessRapid),
                chessBullet = GameType.newInstance(playerStats.chessBullet),
                chessBlitz = GameType.newInstance(playerStats.chessBlitz),
                fideRating = playerStats.fide ?: 0
            )
        }
    }
}
