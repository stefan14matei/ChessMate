package com.example.chessmate.data.presentation

import com.example.chessmate.data.remote.dto.PlayerDto
import com.example.chessmate.data.remote.dto.StatsDto

data class PlayerDetails(
    val username: String,
    val avatar: String?,
    val country: String?,
    val followers: Int?,
    val isStreamer: Boolean?,
    val joined: Int?,
    val lastOnline: Int?,
    val league: String?,
    val location: String?,
    val name: String?,
    val status: String?,
    val title: String?,
    val twitchUrl: String?,
    val verified: Boolean,
    val stats: Stats
) {
    companion object {
        fun newInstance(playerDetails: PlayerDto, playerStats: StatsDto): PlayerDetails {
            return PlayerDetails(
                username = playerDetails.username,
                avatar = playerDetails.avatar,
                country = playerDetails.country,
                followers = playerDetails.followers,
                isStreamer = playerDetails.isStreamer,
                joined = playerDetails.joined,
                lastOnline = playerDetails.lastOnline,
                league = playerDetails.league,
                location = playerDetails.location,
                name = playerDetails.name,
                status = playerDetails.status,
                title = playerDetails.title,
                twitchUrl = playerDetails.twitchUrl,
                verified = playerDetails.verified,
                stats = Stats.newInstance(playerStats)
            )
        }
    }
}

