package com.example.mvvm_architecture_practice_app.data
//MODEL
data class Quote(
    val quoteText: String,
    val author: String
){
    override fun toString(): String {
     return "$quoteText|$author"
    }
}
