package com.tab.core.usecase.impl

import com.tab.core.entity.Card
import com.tab.core.repo.CardRepository
import com.tab.core.usecase.GetCardsUseCase
import kotlinx.coroutines.flow.Flow

class GetCardsUseCaseImpl (
    private val cardRepository: CardRepository
) : GetCardsUseCase{

    override fun getCards(): Flow<List<Card>> = cardRepository.getCards()

}