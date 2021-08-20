package com.example.mvvm_architecture_practice_app.utilities

import com.example.mvvm_architecture_practice_app.data.Database
import com.example.mvvm_architecture_practice_app.data.QuoteRepository
import com.example.mvvm_architecture_practice_app.ui.quotes.QuotesViewModelFactory

object InjectorUtils {
    fun provideQuotesViewModelFactory():QuotesViewModelFactory{
        val database = Database.getInstance().quoteDao
        val quoteRepository = QuoteRepository.getInstance(database)
        return QuotesViewModelFactory(quoteRepository)
    }
}