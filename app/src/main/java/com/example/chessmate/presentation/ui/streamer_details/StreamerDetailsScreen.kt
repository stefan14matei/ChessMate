package com.example.chessmate.presentation.ui.streamer_details

import android.text.TextUtils
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Camera
import androidx.compose.material.icons.rounded.ChevronLeft
import androidx.compose.material.icons.rounded.Leaderboard
import androidx.compose.material.icons.rounded.Map
import androidx.compose.material.icons.rounded.Numbers
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Star
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.rememberAsyncImagePainter
import com.example.chessmate.Screen

@Composable
fun StreamerDetailsScreen (
    navController: NavController,
    viewModel: StreamerDetailsViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.player?.let { streamerDetails ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp,0.dp,0.dp,15.dp)
                    ) {
                        Icon(
                            Icons.Rounded.ChevronLeft,
                            contentDescription = "back",
                            modifier = Modifier
                                .size(30.dp)
                                .align(CenterVertically)
                                .clickable {
                                    navController.navigate(Screen.StreamerListScreen.route)
                                }
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ){
                        Row(
                            modifier = Modifier.align(CenterVertically)
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(streamerDetails.avatar),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(CircleShape)
                                    .border(1.dp, Color.LightGray, CircleShape)
                            )
                            Text(
                                text = streamerDetails.username,
                                style = MaterialTheme.typography.h1,
                                overflow =  TextOverflow.Ellipsis,
                                modifier = Modifier.align(CenterVertically).padding(
                                    horizontal = 15.dp
                                ),
                            )
                        }
                        streamerDetails.title?.let {
                            Row(
                                modifier = Modifier.align(CenterVertically)
                            ) {
                                Icon(
                                    Icons.Rounded.Star,
                                    contentDescription = "title",
                                    modifier = Modifier
                                        .align(CenterVertically)
                                        .padding(horizontal = 5.dp),
                                )
                                Text(
                                    text = streamerDetails.title,
                                    style = MaterialTheme.typography.body1,
                                    modifier = Modifier.align(CenterVertically),
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "General",
                        style = MaterialTheme.typography.h3,
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Row {
                        Icon(
                            Icons.Rounded.Leaderboard,
                            contentDescription = "leaderboard",
                            modifier = Modifier
                                .align(CenterVertically)
                                .padding(horizontal = 5.dp),
                        )
                        Text(
                            text = "League: ",
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier.align(CenterVertically)
                        )
                        Text(
                            text = streamerDetails.league?: "No league found",
                            style = MaterialTheme.typography.body1,
                            color = if(streamerDetails.league.isNullOrBlank()) Color.Red else Color.Unspecified,
                            modifier = Modifier.align(CenterVertically),
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        Icon(
                            Icons.Rounded.Numbers,
                            contentDescription = "followers",
                            modifier = Modifier
                                .align(CenterVertically)
                                .padding(horizontal = 5.dp),
                        )
                        Text(
                            text = "Followers: ",
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier.align(CenterVertically)
                        )
                        Text(
                            text = streamerDetails.followers?.let { streamerDetails.followers.toString() } ?: run { "No followers" },
                            style = MaterialTheme.typography.body1,
                            color = if(streamerDetails.league.isNullOrBlank()) Color.Red else Color.Unspecified,
                            modifier = Modifier.align(CenterVertically),
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        Icon(
                            Icons.Rounded.Map,
                            contentDescription = "location",
                            modifier = Modifier
                                .align(CenterVertically)
                                .padding(horizontal = 5.dp),
                        )
                        Text(
                            text = "Location: ",
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier.align(CenterVertically)
                        )
                        Text(
                            text = streamerDetails.location?: "No location found",
                            style = MaterialTheme.typography.body1,
                            color = if(streamerDetails.league.isNullOrBlank()) Color.Red else Color.Unspecified,
                            modifier = Modifier.align(CenterVertically),
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        Icon(
                            Icons.Rounded.Person,
                            contentDescription = "Account",
                            modifier = Modifier
                                .align(CenterVertically)
                                .padding(horizontal = 5.dp),
                        )
                        Text(
                            text = "Account: ",
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier.align(CenterVertically)
                        )
                        Text(
                            text = streamerDetails.status?: "No account status found",
                            style = MaterialTheme.typography.body1,
                            color = if(streamerDetails.league.isNullOrBlank()) Color.Red else Color.Unspecified,
                            modifier = Modifier.align(CenterVertically),
                        )
                    }
                    streamerDetails.twitchUrl?.let{
                        Spacer(modifier = Modifier.height(10.dp))
                        Row {
                            Icon(
                                Icons.Rounded.Camera,
                                contentDescription = "Camera",
                                modifier = Modifier
                                    .align(CenterVertically)
                                    .padding(horizontal = 5.dp),
                            )
                            Text(
                                text = buildAnnotatedString {
                                    append("Watch on ")
                                    withLink(
                                        LinkAnnotation.Url(
                                            streamerDetails.twitchUrl,
                                            TextLinkStyles(style = SpanStyle(color = Color.Cyan))
                                        )
                                    ) {
                                        // text without https://
                                        // for youtube just display youtube
                                        // for twitch, display the whole link
                                        val tmp = streamerDetails.twitchUrl.substring(8)
                                        if (tmp[0] == 'w') {
                                            append("youtube")
                                        } else {
                                            append(tmp)
                                        }
                                    }
                                },
                                style = MaterialTheme.typography.body1,
                                modifier = Modifier.align(CenterVertically),
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Stats",
                        style = MaterialTheme.typography.h3,
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}