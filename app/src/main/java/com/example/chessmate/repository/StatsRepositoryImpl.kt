package com.example.chessmate.repository

import com.example.chessmate.data.remote.ChessApi
import com.example.chessmate.data.remote.dto.StatsDto
import com.example.chessmate.domain.repository.StatsRepository
import javax.inject.Inject

class StatsRepositoryImpl @Inject constructor(
    private val api: ChessApi
) : StatsRepository {

    override suspend fun getPlayerStats(username: String): StatsDto {
        return api.getStats(username)
    }
}