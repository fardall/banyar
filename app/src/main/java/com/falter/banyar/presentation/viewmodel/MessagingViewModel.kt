package com.falter.banyar.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.falter.banyar.data.messaging.MessagingRepository

/**
 * Created by Fardal on 1/10/2024.
 */

// TODO: Replace repository with correct patern, currently use for simplicity
class MessagingViewModel(
    messagingRepostory: MessagingRepository
) : ViewModel() {

    val messages = messagingRepostory.getMessages()
}