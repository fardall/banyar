package com.falter.banyar.presentation.messaging.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.falter.banyar.data.FakeData
import com.falter.banyar.domain.messaging.model.Message
import com.falter.banyar.presentation.theme.BanyarTheme
import kotlinx.coroutines.launch

/**
 * Created by Fardal on 1/10/2024.
 */

@Composable
fun Messages(
    messages: List<Message>, modifier: Modifier = Modifier
) {
    val scrollState = rememberLazyListState()
    val jumpToBottomEnabled: Boolean by remember {
        derivedStateOf { scrollState.firstVisibleItemIndex > 0 }
    }
    val scope = rememberCoroutineScope()

    Box(modifier = modifier) {
        LazyColumn(state = scrollState, reverseLayout = true, modifier = modifier) {
            items(items = messages, key = { it.id }) { message ->
                val index = messages.indexOf(message)
                val isAuthorFirstMessage = when {
                    index == 0 -> true
                    message.author != messages[index - 1].author -> true
                    else -> false
                }
                val isAuthorLastMessage = when {
                    index == messages.size - 1 -> true
                    message.author != messages[index + 1].author -> true
                    else -> false
                }
                MessageItem(message, isAuthorFirstMessage)
            }
        }

        AnimatedVisibility(
            visible = jumpToBottomEnabled,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically(),
            modifier = Modifier
                .padding(bottom = 30.dp)
                .align(Alignment.BottomCenter)
        ) {
            IconButton(onClick = { scope.launch { scrollState.scrollToItem(0) } }) {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.Blue)
                )
            }
        }
    }
}

@Composable
fun MessageItem(
    message: Message,
    isAuthorFirstMessage: Boolean,
    modifier: Modifier = Modifier
) {
    val messagePadding = if (isAuthorFirstMessage) 32.dp else 4.dp
    Spacer(modifier = Modifier.height(messagePadding))
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(
                    topStart = 50f, topEnd = 50f, bottomStart = 50f, bottomEnd = 10f
                )
            )
    ) {
        Text(
            text = message.content,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
        )
    }
}

@Preview
@Composable
fun MessagePreview() {
    BanyarTheme {
        MessageItem(FakeData.messages[0], true)
    }
}

@Preview(showBackground = true)
@Composable
fun MessagesPreview() {
    Messages(messages = FakeData.messages)
}