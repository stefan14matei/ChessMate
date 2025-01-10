package com.example.chessmate.presentation.ui.streamer_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chessmate.common.Constants
import com.example.chessmate.common.Resource
import com.example.chessmate.domain.use_case.get_streamer.GetPlayerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StreamerDetailsViewModel @Inject constructor(
    private val getPlayerUseCase: GetPlayerUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(StreamerDetailsState())
    val state: State<StreamerDetailsState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_STREAMER_USERNAME)?.let { username ->
            getPlayerData(username)
        }
    }

    private fun getPlayerData(username: String) {
        viewModelScope.launch {
            getPlayerUseCase(username).onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = StreamerDetailsState(
                            player = result.data
                        )
                    }

                    is Resource.Error -> {
                        _state.value = StreamerDetailsState(
                            error = result.message ?: "An unexpected error occurred"
                        )
                    }

                    is Resource.Loading -> {
                        _state.value = StreamerDetailsState(isLoading = true)
                    }
                }
            }.launchIn(viewModelScope)
        }
    }
}