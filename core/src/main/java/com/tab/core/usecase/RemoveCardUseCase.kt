package com.tab.core.usecase

import com.tab.core.entity.Card

interface RemoveCardUseCase {
    fun removeCard(card: Card)
}