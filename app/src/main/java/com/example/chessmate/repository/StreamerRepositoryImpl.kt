package com.example.chessmate.repository

import com.example.chessmate.data.cache.dao.StreamerCacheDao
import com.example.chessmate.data.remote.ChessApi
import com.example.chessmate.data.remote.dto.StreamerDto
import com.example.chessmate.domain.repository.StreamerRepository
import javax.inject.Inject

class StreamerRepositoryImpl @Inject constructor(
    private val streamerCacheDao: StreamerCacheDao,
    private val api: ChessApi
) : StreamerRepository {


    override suspend fun getStreamers(): List<StreamerDto> {
        val streamers = api.getStreamers().streamers
        if (!streamers.isEmpty()) {
            streamers.forEach { streamerCacheDao.insert(it.toStreamerEntity()) }
            return streamers
        }
        else {
            return streamerCacheDao.getAllStreamers()
                .map { streamerCacheEntity -> StreamerDto.newInstance(streamerCacheEntity) }
                .toList()
        }
    }
}