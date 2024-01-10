package com.falter.banyar.data.messaging

import com.falter.banyar.domain.messaging.model.Message
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

/**
 * Created by Fardal on 1/10/2024.
 */

class MessagingRepository {
    fun getMessages(): Flow<Result<List<Message>>> = flow {
        delay(3000)
        if (Random.nextBoolean()) {
            Result.success(messages)
        } else {
            Result.failure(Throwable("Data not found"))
        }
    }
}

val messages = listOf(
    Message(
        "8.03 PM",
        "Fardal",
        "",
        "Hi mate, I wanted to follow up on our conversation from yesterday. Do you have time for a quick chat today?"
    ),
    Message(
        "8.03 PM",
        "Fardal",
        "",
        "Congratulations on your achievement! Your hard work and dedication have truly paid off."
    ),
    Message(
        "8.03 PM",
        "Fardal",
        "",
        "I'm sorry for the confusion earlier. Let's work together to resolve this issue as soon as possible."
    ),
    Message(
        "8.03 PM",
        "Fardal",
        "",
        "Just a reminder: the deadline for project submissions is approaching. Make sure everything is on track."
    ),
    Message(
        "8.03 PM",
        "Fardal",
        "",
        "Just a reminder: the deadline for project submissions is approaching. Make sure everything is on track."
    ),
    Message(
        "8.03 PM",
        "Fardal",
        "",
        "Just a reminder: the deadline for project submissions is approaching. Make sure everything is on track."
    ),
    Message(
        "8.03 PM",
        "Fardal",
        "",
        "Thank you for your assistance. Your support has been invaluable during this process."
    ),
    Message(
        "8.03 PM",
        "Fardal",
        "",
        "I'll be out of the office for the remainder of the day. I'll get back to you first thing tomorrow morning."
    ),
    Message(
        "8.03 PM",
        "Fardal",
        "",
        "We're excited to announce our upcoming event! Save the date and stay tuned for more details."
    ),
)