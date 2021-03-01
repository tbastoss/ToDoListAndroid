package com.tab.todolist.di

import com.tab.core.repo.CardRepository
import com.tab.core.usecase.CreateCardUseCase
import com.tab.core.usecase.GetCardsUseCase
import com.tab.core.usecase.RemoveCardUseCase
import com.tab.core.usecase.SaveCardUseCase
import com.tab.core.usecase.impl.CreateCardUseCaseImpl
import com.tab.core.usecase.impl.GetCardsUseCaseImpl
import com.tab.core.usecase.impl.RemoveCardUseCaseImpl
import com.tab.core.usecase.impl.SaveCardUseCaseImpl
import com.tab.todolist.repo.CardRepositoryImpl
import com.tab.todolist.viewmodel.ToDoListFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viweModelModule = module {

    fun provideViewModel(getCardsUseCase: GetCardsUseCase,
                         removeCardUseCase: RemoveCardUseCase,
                         createCardUseCase: CreateCardUseCase): ToDoListFragmentViewModel {
        return ToDoListFragmentViewModel(getCardsUseCase, removeCardUseCase, createCardUseCase)
    }

    single { provideViewModel(get(), get(), get()) }

}

val useCaseModule = module {

    fun provideRepository(): CardRepository {
        return CardRepositoryImpl()
    }

    fun provideCreateCardUseCase(repository: CardRepository): CreateCardUseCase {
        return CreateCardUseCaseImpl(repository)
    }

    fun provideGetCardsUseCase(repository: CardRepository): GetCardsUseCase {
        return GetCardsUseCaseImpl(repository)
    }

    fun provideRemoveCardUseCase(repository: CardRepository): RemoveCardUseCase {
        return RemoveCardUseCaseImpl(repository)
    }

    fun provideSaveCardUseCase(repository: CardRepository): SaveCardUseCase {
        return SaveCardUseCaseImpl(repository)
    }

    single { provideRepository() }
    single { provideCreateCardUseCase(get()) }
    single { provideGetCardsUseCase(get()) }
    single { provideRemoveCardUseCase(get()) }
    single { provideSaveCardUseCase(get()) }
}

//    fun provideGetCardsUseCase(repository: CardRepository) : GetCardsUseCase {
//        return GetCardsUseCaseImpl(repository)
//    }
//
//    fun provideRemoveCardUseCase(repository: CardRepository) : RemoveCardUseCase {
//        return RemoveCardUseCaseImpl(repository)
//    }
//
//    fun provideCreateCardUseCase(repository: CardRepository) : CreateCardUseCase {
//        return CreateCardUseCaseImpl(repository)
//    }
//
//    single { provideGetCardsUseCase(get()) }
//    single { provideRemoveCardUseCase(get()) }
//    single { provideCreateCardUseCase(get()) }
//    viewModel { ToDoListFragmentViewModel(get(), get(), get()) }
//}
//
//val useCaseModule = module {
//    fun provideCardRepository() : CardRepository {
//        return CardRepositoryImpl()
//    }
//
//    single {
//        provideCardRepository()
//    }
//}