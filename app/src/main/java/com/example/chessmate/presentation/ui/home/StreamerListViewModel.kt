package com.example.chessmate.presentation.ui.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chessmate.common.Resource
import com.example.chessmate.data.remote.dto.PlayerDto
import com.example.chessmate.domain.use_case.get_streamer.GetPlayerUseCase
import com.example.chessmate.domain.use_case.get_steamers.GetStreamersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StreamerListViewModel @Inject constructor(
    private val getStreamersUseCase: GetStreamersUseCase,
    private val getPlayerUseCase: GetPlayerUseCase
) : ViewModel() {

    private val _state = mutableStateOf(StreamerListState())
    val state: State<StreamerListState> = _state

    init {
        getStreamers()
    }

    private fun getStreamers() {
        getStreamersUseCase().onEach { res ->
            when (res) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(streamers = res.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value =
                        StreamerListState(error = res.message ?: "An unexpected error occurred")
                }

                is Resource.Loading -> {
                    _state.value = _state.value.copy(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getPlayerData(username: String) {
        viewModelScope.launch {
            getPlayerUseCase.getPlayerData(username).onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data?.let {
                            navigateToDetailScreen(it)
                        }
                    }

                    is Resource.Error -> {
                        _state.value = _state.value.copy(
                            error = result.message ?: "An unexpected error occurred"
                        )
                    }

                    is Resource.Loading -> {
                        _state.value = _state.value.copy(isLoading = true)
                    }
                }
            }.launchIn(viewModelScope)
        }
    }

    private fun navigateToDetailScreen(player: PlayerDto) {
        _state.value = _state.value.copy(player = player)
    }

    fun resetPlayer() {
        _state.value = _state.value.copy(player = null)
    }
}