package com.tab.todolist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.tab.core.entity.Card
import com.tab.core.repo.CardRepository
import com.tab.core.usecase.CreateCardUseCase
import com.tab.core.usecase.GetCardsUseCase
import com.tab.core.usecase.RemoveCardUseCase
import com.tab.core.usecase.impl.CreateCardUseCaseImpl
import com.tab.core.usecase.impl.GetCardsUseCaseImpl
import com.tab.core.usecase.impl.RemoveCardUseCaseImpl
import com.tab.todolist.repo.CardRepositoryImpl

class ToDoListFragmentViewModel : ViewModel() {

    private val cardRepository: CardRepository = CardRepositoryImpl()
    private val getCardsUseCase: GetCardsUseCase = GetCardsUseCaseImpl(cardRepository)
    private val removeCardUseCase: RemoveCardUseCase = RemoveCardUseCaseImpl(cardRepository)
    private val createCardUseCase: CreateCardUseCase = CreateCardUseCaseImpl(cardRepository)

    val cardsLiveData: LiveData<List<Card>> = getCardsUseCase.getCards().asLiveData()

    fun createCard(title: String, description: String) {
        createCardUseCase.createCard(title, description)
    }

    fun removeCard(card: Card) {
        removeCardUseCase.removeCard(card)
    }

}