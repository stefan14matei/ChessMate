package com.example.chessmate.repository

import com.example.chessmate.data.cache.dao.PlayerCacheDao
import com.example.chessmate.data.cache.dao.StreamerCacheDao
import com.example.chessmate.data.remote.ChessApi
import com.example.chessmate.data.remote.dto.PlayerDto
import com.example.chessmate.data.remote.dto.StreamerDto
import com.example.chessmate.domain.repository.StreamerRepository
import javax.inject.Inject

class StreamerRepositoryImpl @Inject constructor(
    private val streamerCacheDao: StreamerCacheDao,
    private val playerCacheDao: PlayerCacheDao,
    private val api: ChessApi
) : StreamerRepository {


    override suspend fun getStreamers(): List<StreamerDto> {
        val streamers = api.getStreamers().streamers
        if (streamers.isNotEmpty()) {
            streamers.forEach { streamerCacheDao.insert(it.toStreamerEntity()) }
            return streamers
        }
        else {
            return streamerCacheDao.getAllStreamers()
                .map { streamerCacheEntity -> StreamerDto.newInstance(streamerCacheEntity) }
                .toList()
        }
    }

    override suspend fun getStreamer(username: String): PlayerDto {
        val streamer = api.getStreamerDetails(username)
        if (streamer != PlayerDto.emptyInstance()) {
            playerCacheDao.insert(streamer.toStreamerEntity())
            return streamer
        }
        else if (playerCacheDao.getPlayerByUsername(username) != null) {
            return PlayerDto.newInstance(playerCacheDao.getPlayerByUsername(username)!!)
        }
        else {
            return PlayerDto.emptyInstance()
        }
    }
}