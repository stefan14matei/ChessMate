package com.example.chessmate.presentation.ui.streamer_details

import com.example.chessmate.data.presentation.PlayerDetails

data class StreamerDetailsState (
    val isLoading: Boolean = false,
    val error: String = "",
    val player: PlayerDetails? = null,
)
