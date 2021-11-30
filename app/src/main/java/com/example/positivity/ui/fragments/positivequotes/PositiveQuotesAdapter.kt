package com.example.positivity.ui.fragments.positivequotes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.positivity.databinding.ItemPositiveQuoteBinding

class PositiveQuotesAdapter(
    private val quotesList : ArrayList<String>,
    private var position : Int,
) : RecyclerView.Adapter<PositiveQuotesAdapter.PositiveQuotesViewHolder>() {

    class PositiveQuotesViewHolder(
        private val binding: ItemPositiveQuoteBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(quote : String){
            binding.tvQuote.text = quote
        }

        companion object{
            fun from(parent : ViewGroup) : PositiveQuotesViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemPositiveQuoteBinding.inflate(layoutInflater, parent, false)
                return PositiveQuotesViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PositiveQuotesViewHolder {
        return PositiveQuotesViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PositiveQuotesViewHolder, position: Int) {
        val currentQuote = quotesList[this.position]
        holder.bind(currentQuote)
    }

    override fun getItemCount(): Int {
        return quotesList.size
    }

    fun updatePosition(position : Int){
        this.position = position
    }
}