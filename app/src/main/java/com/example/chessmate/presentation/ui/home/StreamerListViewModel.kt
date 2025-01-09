package com.example.chessmate.presentation.ui.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chessmate.common.Resource
import com.example.chessmate.domain.use_case.get_steamers.GetStreamersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class StreamerListViewModel @Inject constructor(
    private val getStreamersUseCase: GetStreamersUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(StreamerListState())
    val state: State<StreamerListState> = _state

    init {
        getStreamers()
    }

    private fun getStreamers() {
        getStreamersUseCase().onEach { res ->
            when(res) {
                is Resource.Success -> {
                    _state.value = StreamerListState(streamers = res.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = StreamerListState(error = res.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _state.value = StreamerListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}