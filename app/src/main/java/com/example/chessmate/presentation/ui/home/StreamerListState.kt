package com.example.chessmate.presentation.ui.home

import com.example.chessmate.data.remote.dto.PlayerDto
import com.example.chessmate.data.remote.dto.StreamerDto

data class StreamerListState(
    val isLoading: Boolean = false,
    val error: String = "",
    val streamers: List<StreamerDto> = emptyList(),
    val player: PlayerDto? = null
)