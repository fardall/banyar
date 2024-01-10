package com.falter.banyar.di

import com.falter.banyar.data.messaging.MessagingRepository
import com.falter.banyar.presentation.viewmodel.MessagingViewModel
import org.koin.dsl.module

/**
 * Created by Fardal on 1/10/2024.
 */

val messagingModule = module {
    single { MessagingRepository() }
    single { MessagingViewModel(get()) }
}