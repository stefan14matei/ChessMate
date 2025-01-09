package com.example.chessmate.domain.use_case.get_steamers

import com.example.chessmate.common.Resource
import com.example.chessmate.data.remote.dto.StreamerDto
import com.example.chessmate.domain.repository.StreamerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetStreamersUseCase @Inject constructor(
    private val repository: StreamerRepository
){
    operator fun invoke(): Flow<Resource<List<StreamerDto>>> = flow {
        try {
            emit(Resource.Loading())

            val streamers = repository.getStreamers()

            emit(Resource.Success(streamers))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error( "Couldn't reach server. Check internet connection"))
        }
    }
}