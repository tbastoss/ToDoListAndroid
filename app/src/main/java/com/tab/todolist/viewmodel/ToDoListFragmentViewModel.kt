package com.tab.todolist.viewmodel

import androidx.lifecycle.*
import com.tab.core.entity.Card
import com.tab.core.repo.CardRepository
import com.tab.core.usecase.CreateCardUseCase
import com.tab.core.usecase.GetCardsUseCase
import com.tab.core.usecase.RemoveCardUseCase
import com.tab.core.usecase.impl.CreateCardUseCaseImpl
import com.tab.core.usecase.impl.GetCardsUseCaseImpl
import com.tab.core.usecase.impl.RemoveCardUseCaseImpl
import com.tab.todolist.repo.CardRepositoryImpl
import kotlinx.coroutines.launch

class ToDoListFragmentViewModel constructor(
    private val getCardsUseCase: GetCardsUseCase,
    private val removeCardUseCase: RemoveCardUseCase,
    private val createCardUseCase: CreateCardUseCase,
) : ViewModel() {

    private val _cadsLiveData = MutableLiveData<List<Card>>()
    val cardsLiveData: LiveData<List<Card>>
        get() = _cadsLiveData

    init {
        fetchCardList()
    }

    fun createCard(title: String, description: String) {
        viewModelScope.launch {
            createCardUseCase.createCard(title, description)
            fetchCardList()
        }
    }

    fun removeCard(card: Card) {
        viewModelScope.launch {
            removeCardUseCase.removeCard(card)
            fetchCardList()
        }
    }

    private fun fetchCardList() {
        viewModelScope.launch {
            _cadsLiveData.postValue(getCardsUseCase.getCards())
        }
    }
}