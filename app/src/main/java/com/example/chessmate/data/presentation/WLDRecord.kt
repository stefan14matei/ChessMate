package com.example.chessmate.data.presentation

import com.example.chessmate.data.remote.dto.RecordDto

data class WLDRecord (
    val wins: Int,
    val losses: Int,
    val draws: Int
) {
    companion object {
        fun newInstance(record: RecordDto?): WLDRecord {
            return WLDRecord(
                wins = record?.win ?: 0,
                losses = record?.loss ?: 0,
                draws = record?.draw ?: 0
            )
        }
    }

    override fun toString(): String {
        return "$wins/$losses/$draws"
    }
}
