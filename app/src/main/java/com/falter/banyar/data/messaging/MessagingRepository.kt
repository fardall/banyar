package com.falter.banyar.data.messaging

import com.falter.banyar.data.FakeData
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
            Result.success(FakeData.messages)
        } else {
            Result.failure(Throwable("Data not found"))
        }
    }
}