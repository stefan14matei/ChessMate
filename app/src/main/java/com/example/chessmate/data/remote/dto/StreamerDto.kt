package com.example.chessmate.data.remote.dto

import com.example.chessmate.data.cache.StreamerCacheEntity
import com.google.gson.annotations.SerializedName

data class StreamerDto(
    @SerializedName("avatar")
    val avatar: String,

    @SerializedName("is_community_name")
    val isCommunityStreamer: Boolean,

    @SerializedName("is_live")
    val isLive: Boolean,

    @SerializedName("platforms")
    val platformDtos: List<PlatformDto>,

    @SerializedName("twitch_url")
    val twitchUrl: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("username")
    val username: String
) {
    fun toStreamerEntity(): StreamerCacheEntity {
        return StreamerCacheEntity(
            username = username,
            avatar = avatar,
            isCommunityStreamer = isCommunityStreamer,
            isLive = isLive,
            twitchUrl = twitchUrl,
            url = url
        )
    }

    companion object {
        fun newInstance(streamerCacheEntity: StreamerCacheEntity): StreamerDto {
            return StreamerDto(
                username = streamerCacheEntity.username,
                avatar = streamerCacheEntity.avatar.orEmpty(),
                isCommunityStreamer = streamerCacheEntity.isCommunityStreamer,
                isLive = streamerCacheEntity.isLive,
                twitchUrl = streamerCacheEntity.twitchUrl.orEmpty(),
                platformDtos = emptyList(),
                url = streamerCacheEntity.url.orEmpty()
            )
        }
    }
}
