package com.kamatiaakash.practiceproject.data.local

import androidx.room.*


@Dao
interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuotesList(quotes:List<QuoteEntity>)

    @Query("DELETE  FROM quoteentity")
    suspend fun deleteQuoteList()

    @Query("SELECT * FROM QuoteEntity")
    suspend fun getStoredQuotesList():List<QuoteEntity>
}