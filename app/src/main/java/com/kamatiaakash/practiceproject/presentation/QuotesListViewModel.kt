package com.kamatiaakash.practiceproject.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kamatiaakash.practiceproject.domain.repository.QuoteRepository
import com.kamatiaakash.practiceproject.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuotesListViewModel @Inject constructor(private val repository: QuoteRepository) :ViewModel() {

     var state by mutableStateOf(QuotesListState())

    init {
        getQuotesList()
    }

    fun onEvent(event:QuotesListEvent){
        when(event){
            is QuotesListEvent.Refresh ->{
                getQuotesList(fetchFromRemote = true)
            }
        }
    }

     fun getQuotesList(fetchFromRemote:Boolean = false){
        viewModelScope.launch {
            repository.getQuotesList(fetchFromRemote)
                .collect{result ->
                    when(result){
                        is Resource.Success ->{
                            result.data?.let {quotes ->
                                state =state.copy(
                                    quotes = quotes
                                )
                            }
                        }
                        is Resource.Error ->{
                            state = state.copy(error = result.message.toString())
                        }
                        is Resource.Loading ->{
                            state = state.copy(isLoading = result.isLoading)
                        }
                    }
                }
        }
    }
}