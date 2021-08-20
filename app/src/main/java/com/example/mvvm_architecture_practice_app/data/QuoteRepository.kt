package com.example.mvvm_architecture_practice_app.data

class QuoteRepository private constructor(
    private val quoteDao: QuoteDao
) {

    fun addQuotes(quote: Quote){
        quoteDao.addQuote(quote)
    }


    fun  getQuotes() = quoteDao.getQuotes()

    companion object {

        @Volatile private var instance: QuoteRepository? = null

        fun getInstance(quoteDao: QuoteDao) = instance ?: synchronized(this) {
                instance ?:  QuoteRepository(quoteDao).also { instance = it }
            }






    }
}