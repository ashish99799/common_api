package com.common.api.data.android.ui.screens.post

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.common.api.data.common.doOnFailure
import com.common.api.data.common.doOnLoading
import com.common.api.data.common.doOnSuccess
import com.common.api.data.data.model.Post
import com.common.api.data.data.repository.ApiRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PostViewModel constructor(
    private val repository: ApiRepository
) : ViewModel() {

    private val _postResponse: MutableState<PostState> = mutableStateOf(PostState())
    val postResponse: State<PostState> = _postResponse

    init {
        viewModelScope.launch {
            repository.getPosts()
                .doOnSuccess {
                    _postResponse.value = PostState(data = it)
                }
                .doOnFailure {
                    _postResponse.value = PostState(error = it?.message ?: "Something went wrong!")
                }
                .doOnLoading {
                    _postResponse.value = PostState(isLoading = true)
                }
                .collect()
        }
    }
}

data class PostState(
    val data: List<Post> = emptyList(),
    val error: String = "",
    val isLoading: Boolean = false
)