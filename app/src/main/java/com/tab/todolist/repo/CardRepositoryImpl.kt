package com.tab.todolist.repo

import com.tab.core.entity.Card
import com.tab.core.repo.CardRepository
import com.tab.todolist.MockedCardList
import kotlinx.coroutines.flow.Flow

class CardRepositoryImpl : CardRepository {

    override suspend fun getCards(): List<Card> = MockedCardList.getCardsMockedList()

    override suspend fun saveCard(card: Card) {
        MockedCardList.addCard(card)
    }

    override suspend fun removeCard(card: Card) {
        MockedCardList.removeCard(card)
    }
}