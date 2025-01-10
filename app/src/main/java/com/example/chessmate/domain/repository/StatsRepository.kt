package com.example.chessmate.domain.repository

import com.example.chessmate.data.remote.dto.StatsDto

interface StatsRepository {

    suspend fun getPlayerStats(username: String): StatsDto
}