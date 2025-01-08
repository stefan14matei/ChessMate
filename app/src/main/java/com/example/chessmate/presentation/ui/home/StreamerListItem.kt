package com.example.chessmate.presentation.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import com.example.chessmate.data.remote.dto.StreamerDto
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.Alignment.Companion.CenterVertically

@Composable
fun StreamerListItem (
    streamer: StreamerDto,
    onItemClick: (StreamerDto) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable{ onItemClick(streamer)}
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = "${streamer.username}",
            style = MaterialTheme.typography.body1,
            overflow =  TextOverflow.Ellipsis,
        )
        Text(
            text = if(streamer.isLive) "Live" else "Offline",
            color = if(streamer.isLive) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(CenterVertically)
        )
    }
}