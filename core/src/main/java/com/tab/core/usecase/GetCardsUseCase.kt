package com.tab.core.usecase

import com.tab.core.entity.Card
import kotlinx.coroutines.flow.Flow

interface GetCardsUseCase {
    fun getCards(): Flow<List<Card>>
}