package com.example.chessmate.domain.use_case.get_streamer

import com.example.chessmate.common.Resource
import com.example.chessmate.data.presentation.PlayerDetails
import com.example.chessmate.data.remote.ChessApi
import com.example.chessmate.data.remote.dto.PlayerDto
import com.example.chessmate.domain.repository.StatsRepository
import com.example.chessmate.domain.repository.StreamerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPlayerUseCase @Inject constructor(
    private val streamerRepository: StreamerRepository,
    private val statsRepository: StatsRepository
) {
    operator fun invoke(username: String): Flow<Resource<PlayerDetails>> = flow {
        try {
            emit(Resource.Loading())

            val player = streamerRepository.getStreamer(username)
            val stats = statsRepository.getPlayerStats(username)

            val playerDetails = PlayerDetails.newInstance(player, stats)

            emit(Resource.Success(playerDetails))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}