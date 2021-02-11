package com.tab.todolist.repo

import com.tab.core.entity.Card
import com.tab.core.repo.CardRepository
import com.tab.todolist.MockedCardList
import kotlinx.coroutines.flow.Flow

class CardRepositoryImpl : CardRepository {

    override fun getCards(): Flow<List<Card>> = MockedCardList.getCardsMockedList()

    override fun saveCard(card: Card) {
        MockedCardList.addCard(card)
    }

    override fun removeCard(card: Card) {
        MockedCardList.removeCard(card)
    }
}