package com.example.chessmate.presentation.ui.home

import android.text.TextUtils
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.chessmate.data.remote.dto.StreamerDto
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.sp
import coil3.compose.rememberAsyncImagePainter

@Composable
fun StreamerListItem (
    streamer: StreamerDto,
    onItemClick: (StreamerDto) -> Unit
) {
    Column (
        modifier = Modifier
            .clickable { onItemClick(streamer) }
            .padding(10.dp)
            .fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ){
            Row {
                Image(
                    painter = rememberAsyncImagePainter(streamer.avatar),
                    contentDescription = null,
                    modifier = Modifier
                        .size(45.dp)
                        .clip(CircleShape)
                        .border(1.dp, Color.LightGray, CircleShape)
                )
                Text(
                    text = streamer.username,
                    style = MaterialTheme.typography.body1,
                    overflow =  TextOverflow.Ellipsis,
                    modifier = Modifier.align(CenterVertically).padding(
                        horizontal = 15.dp
                    ),
                )
            }
            Text(
                text = if(streamer.isLive) "Live" else "Offline",
                color = if(streamer.isLive) Color.Green else Color.Red,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.align(CenterVertically),
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
        ){
            if (!TextUtils.isEmpty(streamer.twitchUrl)) Text(
               text = buildAnnotatedString {
                    append("Watch now on ")
                    withLink(
                        LinkAnnotation.Url(
                            streamer.twitchUrl,
                            TextLinkStyles(style = SpanStyle(color = Color.Cyan))
                        )
                    ) {
                        // text without https://
                        // for youtube just display youtube
                        // for twitch, display the whole link
                        val tmp = streamer.twitchUrl.substring(8)
                        if(tmp[0] == 'w'){
                            append("youtube")
                        } else {
                            append(tmp)
                        }
                    }
                },
                style = MaterialTheme.typography.body2,
                fontSize = 13.sp
            )
        }
    }
}