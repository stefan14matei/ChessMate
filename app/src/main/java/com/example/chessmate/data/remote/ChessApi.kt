package com.example.chessmate.data.remote

import com.example.chessmate.data.remote.dto.ClubDto
import com.example.chessmate.data.remote.dto.PlayerDto
import com.example.chessmate.data.remote.dto.StreamersResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ChessApi {

    @GET("/pub/streamers")
    suspend fun getStreamers(): StreamersResponseDto

    @GET("/player/{username}")
    suspend fun getStreamerDetails(@Path("username") username : String): PlayerDto

    @GET("/pub/player/{username}/clubs")
    suspend fun getClubs(@Path("username") username : String): List<ClubDto>

}