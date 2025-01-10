package com.example.chessmate


open class Screen(val route: String) {
    object StreamerListScreen: Screen("streamer_list_screen")
    object StreamerDetailsScreen: Screen("streamer_details_screen")
}