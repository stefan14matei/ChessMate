package com.example.chessmate.data.presentation

import com.example.chessmate.data.remote.dto.GameTypeDto

data class GameType (
    val last: Game,
    val best: Game,
    val record: WLDRecord
) {
    companion object {
        fun newInstance(gameTypeDto: GameTypeDto?): GameType {
            if (gameTypeDto != null) {
                return GameType(
                    last = Game.newInstance(gameTypeDto.last),
                    best = Game.newInstance(gameTypeDto.best),
                    record = WLDRecord.newInstance(gameTypeDto.record)
                )
            }
            else {
                return emptyInstance()
            }
        }

        fun emptyInstance(): GameType {
            return GameType(
                last = Game.newInstance(null),
                best = Game.newInstance(null),
                record = WLDRecord.newInstance(null)
            )
        }
    }
}
