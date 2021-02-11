package com.tab.core.usecase

import com.tab.core.entity.Card


interface SaveCardUseCase {
    fun saveCard(newCard: Card)
}