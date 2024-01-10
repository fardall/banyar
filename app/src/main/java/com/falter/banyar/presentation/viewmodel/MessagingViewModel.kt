package com.falter.banyar.presentation.viewmodel

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.falter.banyar.data.FakeData
import com.falter.banyar.data.messaging.MessagingRepository
import com.falter.banyar.domain.messaging.model.Message

/**
 * Created by Fardal on 1/10/2024.
 */

// TODO: Replace repository with correct patern, currently use for simplicity
class MessagingViewModel(
    messagingRepostory: MessagingRepository
) : ViewModel() {

    private val _messages = FakeData.messages.toMutableStateList()
    val messages: List<Message> = _messages

}