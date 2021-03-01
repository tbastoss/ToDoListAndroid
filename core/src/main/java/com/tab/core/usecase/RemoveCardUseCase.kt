package com.tab.core.usecase

import com.tab.core.entity.Card

interface RemoveCardUseCase {
    suspend fun removeCard(card: Card)
}