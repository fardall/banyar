package com.falter.banyar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.falter.banyar.presentation.messaging.MessagingScreen
import com.falter.banyar.presentation.viewmodel.MessagingViewModel
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier.fillMaxSize()) {
                BanyarApp()
            }
        }
    }
}

@Composable
fun BanyarApp() {
    val viewModel = koinViewModel<MessagingViewModel>()
    MessagingScreen(viewModel.messages)
}