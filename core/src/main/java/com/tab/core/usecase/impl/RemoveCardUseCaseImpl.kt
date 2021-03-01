package com.tab.core.usecase.impl

import com.tab.core.entity.Card
import com.tab.core.repo.CardRepository
import com.tab.core.usecase.RemoveCardUseCase

class RemoveCardUseCaseImpl (
    private val cardRepository: CardRepository
) : RemoveCardUseCase {

    override suspend fun removeCard(card: Card) {
        cardRepository.removeCard(card)
    }
}