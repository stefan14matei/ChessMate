package com.example.chessmate.data.remote.dto


import com.example.chessmate.data.cache.PlayerCacheEntity
import com.google.gson.annotations.SerializedName

data class PlayerDto(
    @SerializedName("avatar")
    val avatar: String,

    @SerializedName("country")
    val country: String,

    @SerializedName("followers")
    val followers: Int,

    @SerializedName("@id")
    val id: String,

    @SerializedName("is_streamer")
    val isStreamer: Boolean,

    @SerializedName("joined")
    val joined: Int,

    @SerializedName("last_online")
    val lastOnline: Int,

    @SerializedName("league")
    val league: String,

    @SerializedName("location")
    val location: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("player_id")
    val playerId: Int,

    @SerializedName("status")
    val status: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("twitch_url")
    val twitchUrl: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("username")
    val username: String,

    @SerializedName("verified")
    val verified: Boolean
) {
    fun toStreamerEntity(): PlayerCacheEntity {
        return PlayerCacheEntity(
            username = username,
            avatar = avatar,
            country = country,
            followers = followers,
            isStreamer = isStreamer,
            joined = joined,
            lastOnline = lastOnline,
            league = league,
            location = location,
            name = name,
            status = status,
            title = title,
            twitchUrl = twitchUrl,
            url = url,
            verified = verified
        )
    }

    companion object {
        fun newInstance(playerCacheEntity: PlayerCacheEntity): PlayerDto {
            return PlayerDto(
                username = playerCacheEntity.username,
                avatar = playerCacheEntity.avatar.orEmpty(),
                country = playerCacheEntity.country.orEmpty(),
                followers = playerCacheEntity.followers ?: 0,
                isStreamer = playerCacheEntity.isStreamer ?: false,
                joined = playerCacheEntity.joined ?: 0,
                lastOnline = playerCacheEntity.lastOnline ?: 0,
                league = playerCacheEntity.league.orEmpty(),
                location = playerCacheEntity.location.orEmpty(),
                name = playerCacheEntity.name.orEmpty(),
                status = playerCacheEntity.status.orEmpty(),
                title = playerCacheEntity.title.orEmpty(),
                twitchUrl = playerCacheEntity.twitchUrl.orEmpty(),
                url = playerCacheEntity.url.orEmpty(),
                verified = playerCacheEntity.verified ?: false,
                id = "",
                playerId = 0
            )
        }

    }
}