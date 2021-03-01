package com.tab.todolist

import com.tab.core.entity.Card
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOf

object MockedCardList {

    val cardList = MutableStateFlow(List(0) {
        Card("title" + it, "description", true)
    })

    fun getCardsMockedList(): List<Card> = cardList.value

    fun addCard(card: Card) {
        cardList.value += card
    }

    fun removeCard(card: Card) {
        cardList.value -= card
    }

}