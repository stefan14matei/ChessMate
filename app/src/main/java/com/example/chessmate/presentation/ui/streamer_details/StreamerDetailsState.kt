package com.example.chessmate.presentation.ui.streamer_details

import com.example.chessmate.data.remote.dto.PlayerDto

data class StreamerDetailsState (
    val isLoading: Boolean = false,
    val error: String = "",
    val player: PlayerDto? = null,
)
