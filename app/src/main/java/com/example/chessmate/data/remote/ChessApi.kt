package com.example.chessmate.data.remote

import com.example.chessmate.data.remote.dto.PlayerDto
import com.example.chessmate.data.remote.dto.StreamerDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ChessApi {

    @GET("/streamers")
    suspend fun getStreamers(): List<StreamerDto>

    @GET("/player/{username}")
    suspend fun getStreamerDetails(@Path("username") username : String): PlayerDto
}