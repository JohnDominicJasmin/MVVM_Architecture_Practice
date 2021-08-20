package com.example.mvvm_architecture_practice_app.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
//DAO
class QuoteDao {

private val quoteList = mutableListOf<Quote>()
private val liveDataQuotes = MutableLiveData<List<Quote>>()

    init {
        liveDataQuotes.value = quoteList
    }

    fun addQuote(quote: Quote){
        quoteList.add(quote)
        liveDataQuotes.value = quoteList
    }

    fun getQuotes() = liveDataQuotes as LiveData<List<Quote>>
}