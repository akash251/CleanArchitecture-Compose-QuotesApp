package com.kamatiaakash.practiceproject.di

import android.app.Application
import androidx.room.Room
import com.kamatiaakash.practiceproject.data.local.QuoteDatabase
import com.kamatiaakash.practiceproject.data.remote.QuoteApi
import com.kamatiaakash.practiceproject.data.repository.QuoteRepositoryImpl
import com.kamatiaakash.practiceproject.domain.repository.QuoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object QuoteModule {

    @Provides
    @Singleton
    fun provideQuoteApi():QuoteApi{
        return Retrofit.Builder().baseUrl(QuoteApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuoteApi::class.java)
    }

    @Provides
    @Singleton
    fun provideQuoteDatabase(app:Application):QuoteDatabase{
        return Room.databaseBuilder(
            app,
            QuoteDatabase::class.java,
            "quotes_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideQuoteRepository(db:QuoteDatabase,api:QuoteApi):QuoteRepository{
        return QuoteRepositoryImpl(api = api,db = db)
    }
}