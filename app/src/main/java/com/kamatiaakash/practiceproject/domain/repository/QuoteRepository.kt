package com.kamatiaakash.practiceproject.domain.repository

import com.kamatiaakash.practiceproject.domain.model.Quote
import com.kamatiaakash.practiceproject.util.Resource
import kotlinx.coroutines.flow.Flow

interface QuoteRepository {

    suspend fun getQuotesList(fetchFromRemote:Boolean):Flow<Resource<List<Quote>>>
}