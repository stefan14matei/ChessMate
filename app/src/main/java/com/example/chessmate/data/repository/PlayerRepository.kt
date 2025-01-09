package com.example.chessmate.data.repository

import com.example.chessmate.common.Resource
import com.example.chessmate.data.remote.ChessApi
import com.example.chessmate.data.remote.dto.PlayerDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PlayerRepository @Inject constructor(
    private val api: ChessApi
) {
    fun getPlayerData(username: String): Flow<Resource<PlayerDto>> = flow {
        emit(Resource.Loading())
        try {
            val player = api.getStreamerDetails(username)
            emit(Resource.Success(player))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}