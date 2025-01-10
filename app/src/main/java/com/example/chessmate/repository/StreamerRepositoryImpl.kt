package com.example.chessmate.repository

import com.example.chessmate.data.cache.dao.PlayerCacheDao
import com.example.chessmate.data.cache.dao.StreamerCacheDao
import com.example.chessmate.data.remote.ChessApi
import com.example.chessmate.data.remote.dto.PlayerDto
import com.example.chessmate.data.remote.dto.StreamerDto
import com.example.chessmate.domain.repository.StreamerRepository
import java.io.IOException
import javax.inject.Inject

class StreamerRepositoryImpl @Inject constructor(
    private val streamerCacheDao: StreamerCacheDao,
    private val playerCacheDao: PlayerCacheDao,
    private val api: ChessApi
) : StreamerRepository {


    override suspend fun getStreamers(): List<StreamerDto> {
        try {
            val streamers = api.getStreamers().streamers
            streamers.forEach { streamerCacheDao.insert(it.toStreamerEntity()) }
            return streamers

        } catch (e: IOException) {
            return streamerCacheDao.getAllStreamers()
                .map { streamerCacheEntity -> StreamerDto.newInstance(streamerCacheEntity) }
                .toList()
        }
    }

    override suspend fun getStreamer(username: String): PlayerDto {
        try {
            val streamer = api.getStreamerDetails(username)
            playerCacheDao.insert(streamer.toStreamerEntity())
            return streamer
        } catch (e: IOException) {
            return if (playerCacheDao.getPlayerByUsername(username.lowercase()) != null) {
                PlayerDto.newInstance(playerCacheDao.getPlayerByUsername(username.lowercase())!!)
            } else {
                throw e
            }
        }
    }
}