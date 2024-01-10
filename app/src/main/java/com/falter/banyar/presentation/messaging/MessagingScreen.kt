package com.falter.banyar.presentation.messaging

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices.PIXEL_4
import androidx.compose.ui.tooling.preview.Preview
import com.falter.banyar.data.FakeData
import com.falter.banyar.domain.messaging.model.Message
import com.falter.banyar.presentation.messaging.component.Messages

/**
 * Created by Fardal on 1/10/2024.
 */

@Composable
fun MessagingScreen(
    messages: List<Message>,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        // TODO
        Messages(messages, modifier)
        // MessageInput()
    }
}

@Preview(showBackground = true, device = PIXEL_4)
@Composable
fun MessagingScreenPreview() {
    MessagingScreen(FakeData.messages)
}