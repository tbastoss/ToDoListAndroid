package com.tab.core.usecase.impl

import com.tab.core.entity.Card
import com.tab.core.repo.CardRepository
import com.tab.core.usecase.SaveCardUseCase

class SaveCardUseCaseImpl (
    private val cardRepository: CardRepository
) : SaveCardUseCase {

    override fun saveCard(newCard: Card) {
        cardRepository.saveCard(newCard)
    }
}