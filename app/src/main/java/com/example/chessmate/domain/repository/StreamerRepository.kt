package com.example.chessmate.domain.repository

import com.example.chessmate.data.remote.dto.StreamerDto

interface StreamerRepository {

    suspend fun getStreamers(): List<StreamerDto>
}