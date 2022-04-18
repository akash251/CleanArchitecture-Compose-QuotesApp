package com.kamatiaakash.practiceproject.presentation

import com.kamatiaakash.practiceproject.domain.model.Quote

data class QuotesListState(
    val quotes:List<Quote> = emptyList(),
    val isLoading:Boolean = false,
    val isRefreshing:Boolean = false,
    val error:String = ""
)
