package com.tab.core.usecase

import com.tab.core.entity.Card
import kotlinx.coroutines.flow.Flow

interface GetCardsUseCase {
    suspend fun getCards(): List<Card>
}