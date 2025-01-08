package com.example.chessmate.data.repository

import com.example.chessmate.data.remote.ChessApi
import com.example.chessmate.data.remote.dto.StreamerDto
import com.example.chessmate.domain.repository.StreamerRepository
import javax.inject.Inject

class StreamerRepositoryImpl @Inject constructor(
    private val api: ChessApi
) : StreamerRepository {

    override suspend fun getStreamers(): List<StreamerDto> {
        return api.getStreamers()
    }
}