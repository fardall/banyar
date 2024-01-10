package com.falter.banyar.presentation.messaging.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
            items(items = messages, key = { it.timestamp }) { message ->
                Message(message)
            }
        }

        AnimatedVisibility(
            visible = jumpToBottomEnabled,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically(),
            modifier = Modifier.padding(bottom = 30.dp).align(Alignment.BottomCenter)
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
fun Message(message: Message) {
    Text(message.content, modifier = Modifier.padding(horizontal = 16.dp, vertical = 32.dp))
}

@Preview(showBackground = true)
@Composable
fun MessagesPreview() {
    Messages(messages = FakeData.messages)
}