package com.example.chessmate.presentation.ui.home

import com.example.chessmate.common.Resource
import com.example.chessmate.data.remote.dto.StreamerDto

data class StreamerListState (
    val isLoading: Boolean = false,
    val streamers: List<StreamerDto> = emptyList(),
    val error: String = ""
)