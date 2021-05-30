package com.example.mygithub.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mygithub.data.vo.Result
import com.example.mygithub.domain.entity.SearchGithubUser
import com.example.mygithub.domain.entity.SearchGithubUserParams
import com.example.mygithub.domain.usecase.SearchGithubUserByNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GithubUserViewModel @Inject constructor(private val searchGithubUserByNameUseCase: SearchGithubUserByNameUseCase) :
    ViewModel() {
    private val _githubUser = MutableLiveData<Result<List<SearchGithubUser>>>()
    val githubUser: LiveData<Result<List<SearchGithubUser>>>
        get() = _githubUser

    fun searchGithubUserByName(username: String, page: Int, perPage: Int) {
        _githubUser.value = Result.Loading
        viewModelScope.launch {
            _githubUser.value = searchGithubUserByNameUseCase(SearchGithubUserParams(username, page, perPage))
        }
    }
}