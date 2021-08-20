package com.example.mvvm_architecture_practice_app.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.mvvm_architecture_practice_app.data.Quote
import com.example.mvvm_architecture_practice_app.data.QuoteRepository

class QuotesViewModel constructor(
    private val quoteRepository: QuoteRepository
):ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()
    fun addQuotes(quote: Quote) = quoteRepository.addQuotes(quote)

}