package com.example.mvvm_architecture_practice_app.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm_architecture_practice_app.R
import com.example.mvvm_architecture_practice_app.data.Database
import com.example.mvvm_architecture_practice_app.data.Quote
import com.example.mvvm_architecture_practice_app.databinding.ActivityQuotesBinding
import com.example.mvvm_architecture_practice_app.utilities.InjectorUtils

//VIEW
class Quotes : AppCompatActivity() {
    private lateinit var binding: ActivityQuotesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeUI()
    }
    private fun initializeUI(){
        //save instance when screen change orientation
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProvider(this,factory).get(QuotesViewModel::class.java)

        //add livedata observer
        viewModel.getQuotes().observe(this){ quotes->
            val stringBuilder  =  StringBuilder()
            quotes.forEach{
                stringBuilder.append("$it\n\n")
            }
            binding.textViewQuotes.text = stringBuilder.toString()
        }
        binding.buttonAddQuote.setOnClickListener {
            val quote = Quote(binding.editTextQuote.text.toString(), binding.editTextAuthor.text.toString())
            viewModel.addQuotes(quote)
            binding.editTextQuote.setText("")
            binding.editTextAuthor.setText("")
        }
    }
}