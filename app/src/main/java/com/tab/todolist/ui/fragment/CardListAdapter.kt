package com.tab.todolist.ui.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tab.core.entity.Card
import com.tab.todolist.MockedCardList
import com.tab.todolist.MockedCardList.cardList
import com.tab.todolist.databinding.CardListRvItemBinding

class CardListAdapter (
    private val cardRemover: (Card) -> Unit,
) : RecyclerView.Adapter<CardListAdapter.ViewHolder>() {

    private var cardList: List<Card> = emptyList()
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(CardListRvItemBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cardList[position])
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    fun setCardList(list: List<Card>) {
        cardList = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(binding: CardListRvItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private var title: TextView = binding.titleTextView
        private var description: TextView = binding.descriptionTextView
        private var done: Button = binding.doneBtn

        fun bind (card: Card) {
            title.text = card.title
            description.text = card.description
            done.setOnClickListener {
                cardRemover(card)
            }
        }
    }



}