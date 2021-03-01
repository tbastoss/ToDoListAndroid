package com.tab.core.usecase

import com.tab.core.entity.Card

interface CreateCardUseCase {
    suspend fun createCard(title: String, description: String)
}