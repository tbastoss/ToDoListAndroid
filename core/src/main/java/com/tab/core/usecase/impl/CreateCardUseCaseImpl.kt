package com.tab.core.usecase.impl

import com.tab.core.entity.Card
import com.tab.core.repo.CardRepository
import com.tab.core.usecase.CreateCardUseCase
import com.tab.core.usecase.SaveCardUseCase


class CreateCardUseCaseImpl (
    private val cardRepository: CardRepository
        ) : CreateCardUseCase {

    private val saveCardUseCase: SaveCardUseCase = SaveCardUseCaseImpl(cardRepository)

    override suspend fun createCard(title: String, description: String) {
        val card = Card(title, description, true)
        saveCardUseCase.saveCard(card)
    }

}
