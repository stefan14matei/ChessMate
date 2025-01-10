package com.example.chessmate.data.presentation

import com.example.chessmate.data.remote.dto.GameDto

data class Game (
    val rating: Int,
    val date: Int
) {
    companion object {
        fun newInstance(game: GameDto?): Game {
            return Game(
                rating = game?.rating ?: 0,
                date = game?.date ?: 0
            )
        }
    }
}
