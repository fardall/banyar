package com.falter.banyar.domain.messaging.model

import java.util.UUID

/**
 * Created by Fardal on 1/10/2024.
 */
data class Message(
    val timestamp: String,
    val author: String,
    val authorImage: String,
    val content: String,
    val id: String = UUID.randomUUID().toString(),
)