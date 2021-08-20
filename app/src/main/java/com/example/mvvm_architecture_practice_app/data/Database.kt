package com.example.mvvm_architecture_practice_app.data

import android.provider.ContactsContract

class Database private constructor() {

    var quoteDao  = QuoteDao()
        private set


    companion object {
        @Volatile private var instance: Database? = null

        fun getInstance() = instance ?: synchronized(this){
            instance?: Database().also { instance = it }
        }
    }

}