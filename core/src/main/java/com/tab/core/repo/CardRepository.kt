package com.tab.core.repo

import com.tab.core.entity.Card
import kotlinx.coroutines.flow.Flow

interface CardRepository {
    fun getCards(): Flow<List<Card>>
    fun saveCard(card: Card)
    fun removeCard(card: Card)
}