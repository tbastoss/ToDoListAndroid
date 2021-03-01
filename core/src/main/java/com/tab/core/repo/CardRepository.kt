package com.tab.core.repo

import com.tab.core.entity.Card
import kotlinx.coroutines.flow.Flow

interface CardRepository {
    suspend fun getCards(): List<Card>
    suspend fun saveCard(card: Card)
    suspend fun removeCard(card: Card)
}