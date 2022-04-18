package com.kamatiaakash.practiceproject.data.mapper

import com.kamatiaakash.practiceproject.data.local.QuoteEntity
import com.kamatiaakash.practiceproject.data.remote.dto.QuoteDto
import com.kamatiaakash.practiceproject.domain.model.Quote

fun QuoteEntity.toQuote():Quote{
    return Quote(
        quote = quote,
        author = author
    )
}

fun Quote.toQuoteEntity():QuoteEntity{
    return QuoteEntity(
        quote = quote,
        author = author
    )
}

fun QuoteDto.toQuote():Quote{
    return Quote(
        quote = q,
        author = a
    )
}