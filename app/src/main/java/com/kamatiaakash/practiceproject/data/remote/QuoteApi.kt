package com.kamatiaakash.practiceproject.data.remote

import com.kamatiaakash.practiceproject.data.remote.dto.QuoteDto
import retrofit2.http.GET

interface QuoteApi {


    @GET("/api/quotes")
    suspend fun getQuotesList() : List<QuoteDto>


    companion object{
        const val BASE_URL = "https://zenquotes.io/"
    }
}