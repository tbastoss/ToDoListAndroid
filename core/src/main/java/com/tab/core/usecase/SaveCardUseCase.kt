package com.tab.core.usecase

import com.tab.core.entity.Card


interface SaveCardUseCase {
    suspend fun saveCard(newCard: Card)
}