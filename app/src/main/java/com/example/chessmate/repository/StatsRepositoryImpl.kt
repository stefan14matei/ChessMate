package com.example.chessmate.repository

import com.example.chessmate.data.cache.dao.StatsCacheDao
import com.example.chessmate.data.remote.ChessApi
import com.example.chessmate.data.remote.dto.StatsDto
import com.example.chessmate.domain.repository.StatsRepository
import java.io.IOException
import javax.inject.Inject

class StatsRepositoryImpl @Inject constructor(
    private val api: ChessApi,
    private val statsCacheDao: StatsCacheDao
) : StatsRepository {

    override suspend fun getPlayerStats(username: String): StatsDto {
        try {
            val stats = api.getStats(username)
            statsCacheDao.insert(stats.toStatsCacheEntity(username))
            return stats
        }
        catch (e: IOException) {
            return if (statsCacheDao.getPlayerByUsername(username) != null) {
                StatsDto.newInstance(statsCacheDao.getPlayerByUsername(username)!!)
            } else {
                return StatsDto.emptyInstance()
            }
        }
    }
}